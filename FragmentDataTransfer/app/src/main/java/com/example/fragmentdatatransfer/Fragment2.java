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

public class Fragment2 extends Fragment {

    private View view;
    private TextView tv_frag2;
    private Button btn_move;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2, container, false);

        tv_frag2 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null) { // 빈 값이 아니면
            result = getArguments().getString("fromFrag1"); // 프래그먼트1으로부터 setArguments()된 정보를 받아온다.
            tv_frag2.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { // 프래그먼트 1로 이동
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 뭔가를 담을 준비를 할 수 있는 보따리나 꾸러미
                bundle.putString("fromFrag2", "여비 프래그먼트 2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.frameLayout, fragment1);
                transaction.commit(); // 저장
            }
        });

        return view;
    }


}
