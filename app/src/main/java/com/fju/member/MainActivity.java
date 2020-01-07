package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_NICKNAME=21;
    boolean showNikename =false;
    public TextView name;
    public TextView age;
    public TextView gender;
    private NicknameActivity nicknameActivity;
    private  AgeActivity ageActivity;
    private  GenderActivity genderActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!showNikename) {
            Intent nickname = new Intent(this, NicknameActivity.class);
            startActivityForResult(nickname,REQUEST_CODE_NICKNAME);
            //startActivity(nickname);
        }


    }

    public void findViews() {
        name = findViewById(R.id.nameTextView);
        age = findViewById(R.id.ageTextView);
        gender = findViewById(R.id.genderEd);

        String usename = nicknameActivity.getSharedPreferences("nickname", MODE_PRIVATE)
                .getString("edName", "");
        name.setText(usename);

        String userage = ageActivity.getSharedPreferences("AGE", MODE_PRIVATE)
                .getString("edAge", "");
        age.setText(userage);
        String usergender = genderActivity.getSharedPreferences("GENDER", MODE_PRIVATE)
                .getString("edGender", "");
        gender.setText(usergender);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQUEST_CODE_NICKNAME){
            if(resultCode != RESULT_OK){
                Toast.makeText(this,"再見",Toast.LENGTH_LONG).show();
                finish();
            }else {
                showNikename=true;
                findViews();
            }
        }
    }



}
