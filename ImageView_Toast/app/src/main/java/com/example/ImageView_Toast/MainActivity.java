package com.example.ImageView_Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ImageView_Toast.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    //private String str;
    ImageView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //et_test = findViewById(R.id.et_test);
            et_test = (EditText)findViewById(R.id.et_test);

            btn_move = findViewById(R.id.btn_move);
            btn_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //str = et_test.getText().toString();
                    //et_test에서 가져온 문자열은 String으로의 변환이 필요하다
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    //intent.putExtra("str", str);
                    //"str"는 다음 액티비티에서 가져온 데이터를 부르는 별명이다.
                    startActivity(intent); // 액티비티 이동
                }
            });

            test = (ImageView)findViewById(R.id.test);
            //findViewById: ID를 찾아오려는 과정, R은 리소스 폴더의 약자
            test.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"여비저비",Toast.LENGTH_SHORT).show();
                        //토스트메세지 설정. 토스트처럼 툭 튀어나오는 메세지
                    }
            });

    }
}