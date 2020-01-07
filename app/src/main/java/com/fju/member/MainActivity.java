package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_COMPLEMENT=21;
    boolean showNikename =false;
    private TextView name;
    private TextView age;
    private TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!showNikename) {
            Intent nickname = new Intent(this, NicknameActivity.class);
            //startActivityForResult(nickname,REQUEST_CODE_COMPLEMENT);
            startActivity(nickname);
        }

        findViews();
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQUEST_CODE_COMPLEMENT){
            if(resultCode != RESULT_OK){
                Toast.makeText(this,"再見",Toast.LENGTH_LONG).show();
                finish();
            }else {
                showNikename=true;
                findViews();
            }
        }
    }

 */

    private void findViews() {
        name = findViewById(R.id.nameTextView);
        age = findViewById(R.id.ageTextView);
        gender = findViewById(R.id.genderEd);

        String usename = getSharedPreferences("nickname", MODE_PRIVATE)
                .getString("USER", "");
        name.setText(usename);
        String userage = getSharedPreferences("age", MODE_PRIVATE)
                .getString("AGE", "");
        age.setText(userage);
        String usergender = getSharedPreferences("gender", MODE_PRIVATE)
                .getString("GENDER", "");
        gender.setText(usergender);

    }
}
