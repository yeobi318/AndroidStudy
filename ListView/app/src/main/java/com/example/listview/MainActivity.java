package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    //ListView 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        //list의 아이디값 불러오기

        List<String> data = new ArrayList<>();
        //list에 데이터를 넣기 위해서 List 자료형 생성
        //ArrayList: String형태의 데이터가 들어있는 List의 배열

        //ListView와 List를 연결하기 위해서 Adapter필요
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        //ListView에 Adapter적용

        data.add("여비");
        data.add("안드로이드");
        data.add("사과");
        adapter.notifyDataSetChanged();
        //변경된 상태를 저장
    }
}