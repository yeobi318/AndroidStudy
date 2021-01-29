package com.example.spinnerdropdownmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        tv_result = (TextView)findViewById(R.id.tv_result);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 드롭다운 아이템을 눌렀을 때 일어나는 액션
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_result.setText(parent.getItemAtPosition(position).toString());
                // 리스트에서 터치한 위치의 정보를 텍스트 뷰에 설정
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}