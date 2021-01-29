package com.example.threadhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 스레드 시작
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isThread = true;
                thread = new Thread() {
                    public void run() {
                        // 스레드가 실행이 되면
                        while(isThread) {
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // try, catch구문 - 오류가 의심되는 부분에 예외를 처리
                            handler.sendEmptyMessage(0);
                            // 5초 뒤에 핸들러의 메세지를 표시
                        }
                    }
                };
                thread.start();
                // 버튼을 누를 때 스레드가 실행되게 한다.
            }
        });

        // 스레드 종료
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isThread = false;
            }
        });

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "여비 여비", Toast.LENGTH_SHORT).show();
        }
    };
}