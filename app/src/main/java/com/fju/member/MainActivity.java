package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;
    boolean showNikename =false;
    //boolean showAge =false;
    //boolean showGender =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!showNikename) {
            Intent nickname = new Intent(this, NicknameActivity.class);
            startActivityForResult(nickname,REQUEST_CODE_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQUEST_CODE_LOGIN){
            if(resultCode != RESULT_OK){
                Toast.makeText(this,"再見",Toast.LENGTH_LONG).show();
                finish();
            }else {
                showNikename=true;
                findViews();
            }
        }
    }

    private void findViews() {


    }
}
