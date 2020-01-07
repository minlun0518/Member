package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        final EditText edGender=findViewById(R.id.genderEd);
        String useGender = edGender.getText().toString();
        SharedPreferences pref = getSharedPreferences("gender", MODE_PRIVATE);
        pref.edit()
                .putString(useGender, "gender")
                .commit();

        findViewById(R.id.doneGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edGender.getText().toString())) {
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });
    }
}
