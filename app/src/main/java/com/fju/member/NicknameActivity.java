package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import java.security.PrivateKey;

public class NicknameActivity extends AppCompatActivity {
    private static final String TAG = NicknameActivity.class.getSimpleName();
    private static final int REQUEST_CODE_AGE = 21;
    //boolean showAge = false;
    private EditText edName;
    private String username;
    //public TextView user;
    //private MainActivity mainActivit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        ImageView rightGo=findViewById(R.id.nextGoAge);
        rightGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edName = findViewById(R.id.nicknameEt);
                username = edName.getText().toString();

                if (!TextUtils.isEmpty(edName.getText().toString())) {
                    setResult(RESULT_OK);
                    Log.d(TAG,"結果OK");
                    next();
                }
                else {
                    Toast.makeText(NicknameActivity.this, "請輸入姓名", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_AGE) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "請輸入年齡", Toast.LENGTH_LONG).show();
            } else {
                setResult(RESULT_OK);
                //showAge = true;
                Log.d(TAG,"setResult");
                finish();
            }
        }
    }

    public void next(){

        SharedPreferences pref = getSharedPreferences("nickname", MODE_PRIVATE);
        pref.edit()
                .putString("edName", username)
                .apply();
        Log.d(TAG,"PREF"+username);

        Intent goAge = new Intent(this, AgeActivity.class);
        //Intent intent = new Intent(NicknameActivity.this,MainActivity.class);
        //intent.putExtra("edName",username);
        //Log.d(TAG,"intent.putExtra");
        startActivityForResult(goAge,REQUEST_CODE_AGE);
        Log.d(TAG,"goAge");
    }

}
