package com.example.roomexample;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class RoomActivity extends AppCompatActivity {

    //UI View
    private EditText mEditHscore, mEditMscore;
    private TextView mResultTextView;
    private Button mUpdateButton, mInitButton, mBtnNext;

    public static Context context_main;

    // Room Database
    public LocalDatabase db;

    private final String INSERT = "INSERT";
    private final String UPDATE = "UPDATE";
    //private final String DELETE = "DELETE";
    private final String CLEAR = "CLEAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        context_main = this;

        /*
        mAddEdit = (EditText) findViewById(R.id.add_edit);
        mUpdateIdEdit = (EditText) findViewById(R.id.update_id_edit);
        mUpdateTitleEdit = (EditText) findViewById(R.id.editMscore);

        mDeleteEdit = (EditText) findViewById(R.id.delete_edit);

        mResultTextView = (TextView) findViewById(R.id.result_text);
        mAddButton = (Button) findViewById(R.id.add_button);
        mUpdateButton = (Button) findViewById(R.id.update_button);
        mDeleteButton = (Button) findViewById(R.id.init_button);
        mClearButton = (Button) findViewById(R.id.clear_button);
         */

        mEditHscore = (EditText) findViewById(R.id.editHscore);
        mEditMscore = (EditText) findViewById(R.id.editMscore);

        mUpdateButton = (Button) findViewById(R.id.update_button);
        mInitButton = (Button) findViewById(R.id.init_button);
        mBtnNext = (Button) findViewById(R.id.btnNext);

        mResultTextView = (TextView) findViewById(R.id.result_text);

        /**
         * LocalDatabase 객체 생성 -> db
         * databaseBuilder(context, Database 객체, Database 명)
         * Database 명의 파일이 실제로 생성 된다.
         **/
        db = Room.databaseBuilder(this, LocalDatabase.class, "test-db")
                .build();

        /**
         * Database 를 관찰하고 변경이 감지될 때 UI 갱신
         * 데이터베이스 db -> 데이터베이스 mDataModelDAO()
         * -> getAll() 가져오는 List<DataModel> 객체는 관찰 가능한 객체 이므로
         * -> observe 메소드로 관찰하고 변경이 되면 dataList 에 추가한다.
         * 변경된 내용이 담긴 dataList 를 출력한다.
         **/
        /*
         * 람다식 사용
         * file -> project structure -> modules -> source compatibility, target compatibility -> 1.8
         **/
        db.dataModelDAO().getAll().observe(this, dataList -> {
            mResultTextView.setText(dataList.toString());
        });

        /**
         * Insert
         * 데이터배이스 객체 . 데이터베이스 DAO . insert -> new DataModel (텍스트 추가)
         **/

        /*
        mAddButton.setOnClickListener(v -> {
            /**
             *  AsyncTask 생성자에 execute 로 DataModelDAO 객체를 던저준다.
             *  비동기 처리
             **/
        /*
            new DaoAsyncTask(db.dataModelDAO(),INSERT,0,"", "")
                    .execute(new DataModel("0", "0"));
        });
         */

        /**
         * db내의 데이터 전체 삭제
         */
        new DaoAsyncTask(db.dataModelDAO(),CLEAR,"", "").execute();

        /**
         * db 내의 데이터 생성과 동시에 0으로 초기화
         */
        new DaoAsyncTask(db.dataModelDAO(),INSERT,"", "")
                .execute(new DataModel("0", "0"));

        /**
         * Update
         * 데이터베이스 -> getData(id) -> id 입력하여 DataModel 받아오기
         * -> update(DataModel) 해당 데이터 업데이트
         **/
        mUpdateButton.setOnClickListener(v ->
                new DaoAsyncTask(
                        db.dataModelDAO(),
                        UPDATE,
                        mEditHscore.getText().toString(),
                        mEditMscore.getText().toString()
                ).execute()
        );

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, SubActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        /**
         * Delete
         * 데이터베이스 -> getData(id) -> id 입력하여 DataModel 받아오기
         * -> delete(DataModel) 해당 데이터 삭제
         * */
        /*
        mDeleteButton.setOnClickListener(v ->
                new DaoAsyncTask(
                        db.dataModelDAO(),
                        DELETE,
                        Integer.parseInt(mDeleteEdit.getText().toString()),
                        "",
                        ""
                ).execute()
        );
         */


        /**
         * Clear
         * 데이터베이스 -> allClear -> 리스트 전부 지움
         * */

        mInitButton.setOnClickListener(v ->
                new DaoAsyncTask(db.dataModelDAO(),UPDATE,"0", "0").execute()
        );



    }

    /**
     * 비동기 처리 해주는 것은 dataModelDAO() 이다.
     * InsertAsyncTask 생성자를 만들어 dataModelDAO() 객체를 받는다.
     **/
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