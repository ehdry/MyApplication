package com.example.com.myapplication;

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
    Button btnadd,btnsub,btnmul,btndiv;
    TextView textResult;
    String num1,num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs={ R.id.btnnum0, R.id.btnnum1, R.id.btnnum2,R.id.btnnum3,R.id.btnnum4,R.id.btnnum5,
            R.id.btnnum6,R.id.btnnum7,R.id.btnnum8,R.id.btnnum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);

        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);

        textResult = (TextView) findViewById(R.id.textresult);

        for(i=0;i<numBtnIDs.length;i++){
            numButtons[i]=(Button)findViewById(numBtnIDs[i]);
        }
        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),"먼저 텍스트에디트를 선택하세요",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

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
    }
}