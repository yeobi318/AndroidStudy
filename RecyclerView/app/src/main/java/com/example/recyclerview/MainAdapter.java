package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
// Alt + Enter로 implement methods 사용, 필요한 메소드 생성. create class도 있다.

    private ArrayList<MainData> arrayList;
    // ListView를 이용한 ArrayList 생성
   public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }
    // Alt + Insert - Constructor, 생성자 생성
    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ListView가 생성될 때 발생하는 일
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        // 리스트 뷰가 추가될 때 일어나는 일들, 생명주기
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        // 위치 값을 추출
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                // 현재 이름값을 tv_name에서 스트링 형태로 추출
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
                // 클릭하면 curName을 토스트메세지로 출력
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }
    // 리스트 수를 반환하는 메소드

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
            // 리스트 값을 지우고 반영
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            // id값을 뷰 변수에 저장
        }
    }

}