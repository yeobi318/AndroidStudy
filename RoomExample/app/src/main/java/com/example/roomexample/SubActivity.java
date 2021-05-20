package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_hang;
    private TextView tv_mem;

    private LocalDatabase db = ((RoomActivity)RoomActivity.context_main).db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_hang = (TextView)findViewById(R.id.tv_hang);
        tv_mem = (TextView)findViewById(R.id.tv_mem);

        db.dataModelDAO().getAll().observe(this, dataList -> {
            tv_hang.setText(db.hang_score);
            tv_mem.setText(db.mem_score);
        });
    }

    private class DaoAsyncTask extends AsyncTask<DataModel,Void,Void> {

        private DataModelDAO mDataModelDAO;
        private String mType;
        private String hang_score;
        private String mem_score;

        private DaoAsyncTask (DataModelDAO dataModelDAO, String type, String hang_score, String mem_score) {
            this.mDataModelDAO = dataModelDAO;
            this.mType = type;
            this.hang_score = hang_score;
            this.mem_score = mem_score;
        }

        @Override
        public Void doInBackground(DataModel... dataModels) {

            if(mType.equals("INSERT")){
                db.currentID = (int)mDataModelDAO.insert(dataModels[0]);
            }
            else if(mType.equals("UPDATE")){
                if(mDataModelDAO.getData(db.currentID) != null){
                    mDataModelDAO.hangUpdate(db.currentID,hang_score);
                    mDataModelDAO.memUpdate(db.currentID,mem_score);
                    db.hang_score = hang_score;
                    db.mem_score = mem_score;
                }
            }
            /*
            else if(mType.equals("DELETE")){
                if(mDataModelDAO.getData(mId) != null) {
                    mDataModelDAO.delete(mDataModelDAO.getData(mId));
                }
            }
             */
            else if(mType.equals("CLEAR")){
                mDataModelDAO.clearAll();
            }
            return null;
        }

    }
}