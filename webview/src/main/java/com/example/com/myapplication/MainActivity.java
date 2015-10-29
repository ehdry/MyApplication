package com.example.com.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText edtUrl;
    Button btnGo,btnBack;
    WebView web;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = (EditText)findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGO);
        btnBack = (Button)findViewById(R.id.btnBack);
        web = (WebView)findViewById(R.id.webView1);

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String temp;
                temp = edtUrl.getText().toString();
                temp = temp.substring(0,6);
                if(temp.equals("http://"))
                    web.loadUrl(edtUrl.getText().toString());
                else
                    web.loadUrl("http://" + edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                web.goBack();

            }
        });



    }

    class CookWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return super.shouldOverrideUrlLoading(view,url);
        }
        // 페이지 로드가 끝났을때 url을 edtUrl로 적어주는 메서드
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            edtUrl.setText(url);
        }
    }
}

