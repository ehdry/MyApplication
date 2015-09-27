package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnadd,btnsub,btnmul,btndiv,btnmod;
    TextView textResult;
    String num1,num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단계산기");

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);

        btnadd = (Button)findViewById(R.id.addbtn);
        btnsub = (Button)findViewById(R.id.subbtn);
        btnmul = (Button)findViewById(R.id.mulbtn);
        btndiv = (Button)findViewById(R.id.divbtn);
        btnmod = (Button)findViewById(R.id.modbtn);

        textResult = (TextView) findViewById(R.id.result);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)){
                    Toast.makeText(getApplicationContext(),"입력값 에러",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);

                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    Toast.makeText(getApplicationContext(), "입력값 에러", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    Toast.makeText(getApplicationContext(), "입력값 에러", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                        Toast.makeText(getApplicationContext(), "입력값 에러", Toast.LENGTH_SHORT).show();
                } else {
                    if(Double.parseDouble(num2) == 0.0)
                        Toast.makeText(getApplicationContext(), "0으로나눌수없다", Toast.LENGTH_SHORT).show();
                    else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });
        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
                    Toast.makeText(getApplicationContext(), "입력값 에러", Toast.LENGTH_SHORT).show();
                } else {
                    if(Double.parseDouble(num2) == 0.0)
                        Toast.makeText(getApplicationContext(), "0으로나눌수없다", Toast.LENGTH_SHORT).show();
                    else {
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });



    }
}
