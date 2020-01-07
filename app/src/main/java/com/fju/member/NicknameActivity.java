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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NicknameActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_NICKNAME = 21;
    //boolean showAge = false;
    private EditText edName;
    private String username;
 //   private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
   //     user = findViewById(R.id.nameTextView);
        edName = findViewById(R.id.nicknameEt);
        username = edName.getText().toString();

        ImageView rightGo=findViewById(R.id.nextGoAge);
        rightGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edName.getText().toString())) {
                    SharedPreferences pref = getSharedPreferences("nickname", MODE_PRIVATE);
                    pref.edit()
                            .putString("edName", username)
                            .commit();
                    Intent goAge = new Intent(NicknameActivity.this, AgeActivity.class);
                    startActivity(goAge);
                    finish();
                }
                else {
                    Toast.makeText(NicknameActivity.this, "請輸入姓名", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

/*
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_NICKNAME) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "請輸入年齡", Toast.LENGTH_LONG).show();

            } else {
                //showAge = true;
                finish();
            }
        }
    }

    public void nickname(View view){

    }

 */
}
