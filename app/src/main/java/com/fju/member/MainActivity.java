package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_NICKNAME=21;
 //   boolean showNikename =false;
    public TextView name;
    public TextView age;
    public TextView gender;
    private NicknameActivity nicknameActivity;
   // private  AgeActivity ageActivity;
   // private  GenderActivity genderActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameTextView);
        age = findViewById(R.id.ageTextView);
        gender = findViewById(R.id.genderEd);




       // if (!showNikename) {
            Intent nickname = new Intent(this, NicknameActivity.class);
            startActivityForResult(nickname,REQUEST_CODE_NICKNAME);
            //startActivity(nickname);
       // }

    }

    public void setValue() {
        String usename = getSharedPreferences("nickname", MODE_PRIVATE)
                .getString("edName", "");
        name.setText(usename+"");
        Log.d(TAG,usename+"");
        String userage = getSharedPreferences("AGE", MODE_PRIVATE)
                .getString("edAge", "");
        age.setText(userage+"");
        Log.d(TAG,age+"");
        String usergender = getSharedPreferences("GENDER", MODE_PRIVATE)
                .getString("edGender", "");
        gender.setText(usergender+"");
        Log.d(TAG,gender+"");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQUEST_CODE_NICKNAME){
            if(resultCode != RESULT_OK){
                Toast.makeText(this,"再見",Toast.LENGTH_LONG).show();
                //finish();
            }else {
                //showNikename=true;
                setValue();
                Log.d(TAG,"setvalue");
            }
        }
    }



}
