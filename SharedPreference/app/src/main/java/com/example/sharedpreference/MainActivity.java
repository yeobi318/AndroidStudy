package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("Yeobi", "");
        et_save.setText(value);
        // sharedPreference에 저장된 값을 key값을 통해 불러와서 EditText에 삽입
    }


    @Override
    protected void onDestroy() {
    // 앱을 나올때 실행되는 동작, 앱을 나올 때 쓰여진 글자를 저장
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 값을 저장하기 위해서 sharedPreference와 Editor를 연결해야한다.
        String value = et_save.getText().toString();
        // et_save에서 받은 키보드 값을 getText()를 이용해서 value에 저장한다.
        editor.putString("Yeobi", value);
        // 에디터에 값을 저장하면서 별명을 결정
        editor.commit();
        // 저장완료
    }
}
// SharedPreference는 앱설정에서 많이 사용, 앱을 삭제할시 삭제