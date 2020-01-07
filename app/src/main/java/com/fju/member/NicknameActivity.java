package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NicknameActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN = 21;
    boolean showAge = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        final EditText edName=findViewById(R.id.nicknameEt);
        String username = edName.getText().toString();
        SharedPreferences pref = getSharedPreferences("nickname", MODE_PRIVATE);
        pref.edit()
                .putString(username, "name")
                .commit();


        findViewById(R.id.doneGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edName.getText().toString())) {
                    setResult(RESULT_OK);

                }
            }
        });
        if (!showAge) {
            //如果不是登入狀態就呼叫login intent
            Intent goAge = new Intent(this, NicknameActivity.class);
            startActivityForResult(goAge, REQUEST_CODE_LOGIN);
        }
    }

    @Override
    //防止按返回
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {



        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "請輸入年齡", Toast.LENGTH_LONG).show();

            } else {
                showAge = true;
                finish();
            }
        }
    }

    public void nickname(View view){
        EditText nicknameEd = findViewById(R.id.nicknameEt);
        String username = nicknameEd.getText().toString();



    }
}
