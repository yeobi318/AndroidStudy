package com.example.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Yeobi = "여비";
        Log.e("MainActivity : ", Yeobi);
        // 앱이 실행될 때, 로그가 출력되게 한다. 이 로그는 Logcat - Error(Log.e)에 표시된다.
        int a = 10;
        Log.e("MainActivity", String.valueOf(a));
        // 로그는 스트링형태여야 한다.
    }
}