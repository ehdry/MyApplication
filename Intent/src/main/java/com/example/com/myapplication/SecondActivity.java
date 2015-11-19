package com.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends Activity {
    double value =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        String operator = inIntent.getStringExtra("operator");
        if(operator.equals("+")){
            value = inIntent.getDoubleExtra("Num1", 0.0) + inIntent.getDoubleExtra("Num2", 0.0);
        }
        else if(operator.equals("-")){
             value = inIntent.getDoubleExtra("Num1", 0.0) - inIntent.getDoubleExtra("Num2",0.0);
        }
        else if(operator.equals("*")){
             value = inIntent.getDoubleExtra("Num1", 0.0) * inIntent.getDoubleExtra("Num2",0.0);
        }
        else if(operator.equals("/")){
            if(inIntent.getDoubleExtra("Num2",0.0)!=0.0)
                value = inIntent.getDoubleExtra("Num1", 0.0) / inIntent.getDoubleExtra("Num2",0.0);
            else
                value = 0.0;
        }
        else
            value=0.0;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Hap",value);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
