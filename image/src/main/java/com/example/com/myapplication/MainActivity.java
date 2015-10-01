package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView choicetext = (TextView)findViewById(R.id.text1);
    Switch switchbtn = (Switch)findViewById(R.id.switchbtn);
    RadioGroup Group = (RadioGroup)findViewById(R.id.Group1);
    RadioButton jelly = (RadioButton)findViewById(R.id.jelly);
    RadioButton kit = (RadioButton)findViewById(R.id.kitkat);
    RadioButton lol = (RadioButton)findViewById(R.id.lollipop);
    Button exitbtn = (Button)findViewById(R.id.exit);
    Button resetbtn = (Button)findViewById(R.id.reset);
    ImageView I = (ImageView)findViewById(R.id.image1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //switchbtn.setOnCheckedChangeListener();
    }
}
