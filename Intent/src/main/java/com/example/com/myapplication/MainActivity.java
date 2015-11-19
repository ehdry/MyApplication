package com.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    RadioButton addbtn;
    RadioButton subbtn;
    RadioButton mulbtn;
    RadioButton divbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인액티비티");

        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
         addbtn = (RadioButton)findViewById(R.id.add);
         subbtn = (RadioButton)findViewById(R.id.sub);
         mulbtn = (RadioButton)findViewById(R.id.mul);
         divbtn = (RadioButton)findViewById(R.id.div);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText editNum2 = (EditText) findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Double.parseDouble(editNum1.getText().toString()));
                intent.putExtra("Num2", Double.parseDouble(editNum2.getText().toString()));
                if(addbtn.isChecked()){
                    intent.putExtra("operator","+");
                }
                else if(subbtn.isChecked()){
                    intent.putExtra("operator","-");
                }
                else if (mulbtn.isChecked()) {
                    intent.putExtra("operator","*");
                }
                else if(divbtn.isChecked()){
                    intent.putExtra("operator","/");
                }

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            double result = data.getDoubleExtra("value",0.0);
            Toast.makeText(getApplicationContext(),"결과 : " +result,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
