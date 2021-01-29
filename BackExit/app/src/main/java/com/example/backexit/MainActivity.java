package com.example.backexit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;
    // 백버튼을 누른 시간을 0으로 초기화

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        // 백버튼을 눌렀을 때의 액션
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;
        // 현재시간, 백버튼을 누른 시간간격을 정의

        if (0 <= gapTime && 2000 >= gapTime) {
            super.onBackPressed();
        } else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
        // 2초내에 백버튼을 두번 누르면 앱이 종료

    }
}