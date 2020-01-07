package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AgeActivity extends AppCompatActivity {
    private static final String TAG = AgeActivity.class.getSimpleName();
    private static final int REQUEST_CODE_GENDER=21;
    private EditText edAge;
    private String userage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        ImageView rightGo = findViewById(R.id.neaxGoGender);
        rightGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAge = findViewById(R.id.ageEt);
                userage = edAge.getText().toString();

                if (!TextUtils.isEmpty(edAge.getText().toString())) {
                    setResult(RESULT_OK);
                    next();
                } else {
                    Toast.makeText(AgeActivity.this, "請輸年齡", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void next() {
        SharedPreferences pref = getSharedPreferences("AGE", MODE_PRIVATE);
        pref.edit()
                .putString("edAge", userage)
                .apply();
        Log.d(TAG," pref.edit().putString :"+userage);
        Intent goGender = new Intent(this, GenderActivity.class);
        startActivityForResult(goGender,REQUEST_CODE_GENDER);
        Log.d(TAG,"goGender");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_GENDER) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "請輸入性別", Toast.LENGTH_LONG).show();
            } else {
                setResult(RESULT_OK);
                Log.d(TAG,"setResult");
                finish();
            }
        }
    }
}
