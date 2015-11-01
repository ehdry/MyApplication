package com.example.com.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView choicetext;
    private Switch switchbtn;
    private RadioGroup Group;
    private RadioButton jelly, kit, lol;
    private Button exitbtn , resetbtn;
    private ImageView I;

    public void showVisible(Boolean ischecked){
        if(ischecked){
            Group.setVisibility(android.view.View.VISIBLE);
            I.setVisibility(android.view.View.VISIBLE);
            exitbtn.setVisibility(android.view.View.VISIBLE);
            resetbtn.setVisibility(android.view.View.VISIBLE);
        }
        else{
            Group.setVisibility(android.view.View.INVISIBLE);
            I.setVisibility(android.view.View.INVISIBLE);
            exitbtn.setVisibility(android.view.View.INVISIBLE);
            resetbtn.setVisibility(android.view.View.INVISIBLE);
            switchbtn.setChecked(false);
        }
    }
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

        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showVisible(isChecked);
            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showVisible(false);
            }
        });
        jelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.setImageResource(R.mipmap.jellybean);
            }
        });
        kit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.setImageResource(R.mipmap.kitkat);
            }
        });
        lol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.setImageResource(R.mipmap.lollipop);
            }
        });
    }
}
