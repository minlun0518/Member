package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AgeActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;
    boolean showGender =false;
    private EditText edAge;
    private String userage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        edAge = findViewById(R.id.ageEt);
        userage = edAge.getText().toString();

        ImageView rightGo=findViewById(R.id.neaxGoGender);
        rightGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edAge.getText().toString())) {
                    SharedPreferences pref = getSharedPreferences("AGE", MODE_PRIVATE);
                    pref.edit()
                            .putString("edAge", userage)
                            .commit();
                    Intent goGender = new Intent(AgeActivity.this, GenderActivity.class);
                    startActivity(goGender);
                    finish();
                }
                else {
                    Toast.makeText(AgeActivity.this, "請輸年齡", Toast.LENGTH_LONG).show();
                }
            }
        });
        /*
        SharedPreferences pref = getSharedPreferences("ageage", MODE_PRIVATE);
        pref.edit()
                .putString("edAge", userage)
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
        }*/
    }
}
