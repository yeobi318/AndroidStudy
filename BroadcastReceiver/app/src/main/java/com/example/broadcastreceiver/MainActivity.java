package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.net.wifi.WifiManager;

public class MainActivity extends AppCompatActivity {

    public static TextView tv_state;
    private NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_state = findViewById(R.id.tv_state);

        // 브로드캐스트 리시버 등록
        IntentFilter filter = new IntentFilter();
        // 인텐트 필터 - 내가 이런 기능을 만들었으니 늬들은 가져다 써
        receiver = new NetworkReceiver();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter);
        // 리시버에 네트워크 값을 등록
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 리시버를 해제
        unregisterReceiver(receiver);
    }
}