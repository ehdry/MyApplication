package com.example.com.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
    Integer[] posterID = {R.mipmap.poster1,R.mipmap.poster2,R.mipmap.poster3,R.mipmap.poster4
                            ,R.mipmap.poster5,R.mipmap.poster6,R.mipmap.poster7,R.mipmap.poster8
                            ,R.mipmap.poster9,R.mipmap.poster10,R.mipmap.poster11,R.mipmap.poster12
                            ,R.mipmap.poster1,R.mipmap.poster2,R.mipmap.poster3,R.mipmap.poster4
                            ,R.mipmap.poster5,R.mipmap.poster6,R.mipmap.poster7,R.mipmap.poster8
                            ,R.mipmap.poster9,R.mipmap.poster10,R.mipmap.poster11,R.mipmap.poster12};
    String[] posterTitle ={"도리화가","내부자들","열정같은소리하고있네","검은사제들","괴물의아이"
                            ,"헝거게임더파이널","Quiet Night","하트 오브 더 씨","이터널 선샤인"
                            ,"독립사이다","크림슨피크","파워레인저"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView)findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }
        public int getCount(){
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // getCount만큼 반복되는 부분?
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(100,150));//너비 높이?
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos%12]);
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();

                    //View test = getLayoutInflater().inflate(R.layout.dialog,null);

                }
            });
            return imageview;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
