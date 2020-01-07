package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AgeActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;
    boolean showGender =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        EditText edAge=findViewById(R.id.ageEt);
        String userage = edAge.getText().toString();
        SharedPreferences pref = getSharedPreferences("nickname", MODE_PRIVATE);
        pref.edit()
                .putString(userage, "age")
                .commit();

        if (!showGender) {
            Intent goGender = new Intent(this, NicknameActivity.class);
            startActivityForResult(goGender,REQUEST_CODE_LOGIN);
        }

    }
    @Override
    //防止按返回
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "請輸入年齡", Toast.LENGTH_LONG).show();

            } else {
                showGender = true;
                finish();
            }
        }
    }
}
