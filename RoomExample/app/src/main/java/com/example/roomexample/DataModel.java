package com.example.roomexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room 에서 사용할 수 있는 Entity 가 되기위해서
 * @Entity Annotation 추가
 * */
@Entity
public class DataModel {
    /**
     * id = primaryKEY
     * autoGenerate -> 자동으로 증가
     * */
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String mem_score;
    private String hang_score;
    //private String title;

    /*
    // 생성자
    public DataModel(String title){
        this.title = title;
    }
    */

    public DataModel(String hang_score, String mem_score){
        this.hang_score = hang_score;
        this.mem_score = mem_score;
    }

    public void setHang_score(String score) { this.hang_score = score; }

    public void setMem_score(String score) { this.mem_score = score; }
 
    public String getHang_score() { return hang_score; }

    public String getMem_score() { return mem_score; }
 
    public int getId() { return id; }
 
    public void setId(int id) { this.id = id; }


    /**
     * toString 재정의 -> 내용확인하기 위함
     * */
    /**
    @NonNull
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataModel{");
        sb.append("id=").append(id);
        sb.append(", title=").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
    **/

    public String toString() {
        final StringBuffer sb = new StringBuffer("DataModel{");
        sb.append("id=").append(id);
        sb.append(", hang_score=").append(hang_score);
        sb.append(", mem_score=").append(mem_score);
        sb.append('}');
        return sb.toString();
    }

    public String PutHangScore() {
        return mem_score;
    }

    public String PutMemScore() {
        return mem_score;
    }
}