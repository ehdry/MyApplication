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
    TextView choicetext;
    Switch switchbtn;
    RadioGroup Group;
    RadioButton jelly;
    RadioButton kit;
    RadioButton lol;
    Button exitbtn;
    Button resetbtn;
    ImageView I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choicetext = (TextView)findViewById(R.id.text1);
        switchbtn = (Switch)findViewById(R.id.switchbtn);
        Group = (RadioGroup)findViewById(R.id.Group1);
        jelly = (RadioButton)findViewById(R.id.jelly);
        kit = (RadioButton)findViewById(R.id.kitkat);
        lol = (RadioButton)findViewById(R.id.lollipop);
        exitbtn = (Button)findViewById(R.id.exit);
       resetbtn = (Button)findViewById(R.id.reset);
        I = (ImageView)findViewById(R.id.image1);
    }
}
