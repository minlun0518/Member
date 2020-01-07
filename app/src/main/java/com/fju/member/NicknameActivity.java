package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

        if("rd7791".equals(username)&&"12345678".equals(password)){
            setResult(RESULT_OK);
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.rdteacher)
                    .setTitle("登入成功")
                    .setMessage("歡迎最帥的孟賢老師~新年快樂")
                    .setPositiveButton("呵呵", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }
        else {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.bad)
                    .setTitle("登入訊息")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
