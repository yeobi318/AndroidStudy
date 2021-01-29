package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        // 자바 스크립트 허용
        webView.loadUrl(url);
        // 특정 URL주소를 가져온다
        webView.setWebChromeClient(new WebChromeClient());
        // 크롬 브라우저에 최적화
        webView.setWebViewClient(new WebViewClientClass());
        // 일반적인 웹뷰클라이언트
    }

    //스마트폰에서 뒤로가기 키를 눌렀을 때, 정상적으로 종료되어야 함
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
            // 뒤로가기 버튼을 눌렀을 때 뒤로갈 수 있다면 뒤로가라
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //현재 페이지의 URL을 읽어올 수 있는 메소드
            view.loadUrl(url);
            return true;
        }
    }
}