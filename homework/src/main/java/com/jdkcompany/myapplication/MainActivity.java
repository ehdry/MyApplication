package com.jdkcompany.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends Activity {
    Button saveBtn;
    EditText contents;
    TextView date;
    DatePicker dp;
    View dialogView;
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn = (Button)findViewById(R.id.btnWrite);
        contents = (EditText)findViewById(R.id.contents);
        date = (TextView)findViewById(R.id.edtDiary);
        //dp = (DatePicker)findViewById(R.id.datePicker);

        //오늘 날짜를 구함
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        //초기 날짜 세팅
        date.setText(cYear+"년_"+(cMonth+1)+"월_"+cDay+"일");
        //날짜 변경하는 부분
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("날짜 선택");
                dlg.setView(dialogView);
                dp = (DatePicker)dialogView.findViewById(R.id.datePicker);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        str = dp.getYear() + "년_"+(dp.getMonth()+1)+"월_"+dp.getDayOfMonth()+"일";
                        date.setText(str);
                    }
                });
                dlg.show();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = date.getText().toString().trim()+".txt";
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.largeSize:

        }
        return false;
    }
}
