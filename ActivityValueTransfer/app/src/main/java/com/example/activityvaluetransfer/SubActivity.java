package com.example.activityvaluetransfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private EditText et_valuetrans;
    private Button btn_close;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        et_valuetrans = findViewById(R.id.et_valuetrans);
        btn_close = findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("valuetrans", et_valuetrans.getText().toString());
                // 입력폼에 적은 값 담아주기
                setResult(RESULT_OK, intent);
                finish();
                // 현재 액티비티 종료
            }
        });
    }
}
