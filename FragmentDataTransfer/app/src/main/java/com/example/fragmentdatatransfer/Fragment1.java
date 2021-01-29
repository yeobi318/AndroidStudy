package com.example.fragmentdatatransfer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private View view;
    private TextView tv_frag1;
    private Button btn_move;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);

        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null) { // 빈 값이 아니면
            result = getArguments().getString("fromFrag2"); // 프래그먼트2로부터 setArguments()된 정보를 받아온다.
            tv_frag1.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { // 프래그먼트 2로 이동
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 뭔가를 담을 준비를 할 수 있는 보따리나 꾸러미
                bundle.putString("fromFrag1", "여비 프래그먼트 1");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                transaction.replace(R.id.frameLayout, fragment2);
                transaction.commit(); // 저장
            }
        });

        return view;
    }


}
