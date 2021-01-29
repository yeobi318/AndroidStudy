package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    // recyclerView에서 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 레이아웃 매니져를 리사이클러뷰 옆에 생성성
        arrayList = new ArrayList<>();
        mainAdapter = new MainAdapter(arrayList);
        // 어댑터를 배열리스트에 적용
        recyclerView.setAdapter(mainAdapter);
        // 리사이클러뷰에 어댑터를 적용

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn_add를 눌렀을 때의 액션정의
                MainData mainData = new MainData(R.mipmap.ic_launcher, "여비", "리사이클러뷰");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();
            }
        });
    }
}