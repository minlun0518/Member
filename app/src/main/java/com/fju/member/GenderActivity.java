package com.fju.member;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity {
    private static final String TAG = GenderActivity.class.getSimpleName();
    private EditText edGender;
    private String useGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        ImageView doneGo=findViewById(R.id.doneGo);
        doneGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edGender = findViewById(R.id.genderEd);
                useGender = edGender.getText().toString();

               /* if (!TextUtils.isEmpty(edGender.getText().toString())) {
                    setResult(RESULT_OK);
                    SharedPreferences pref = getSharedPreferences("GENDER", MODE_PRIVATE);
                    pref.edit()
                            .putString("edGender", useGender)
                            .commit();
                    finish();
                }
                else {
                    Toast.makeText(GenderActivity.this, "請輸性別", Toast.LENGTH_LONG).show();
                }

                */
               check();

            }
        });
    }

    public void check(){
        if (!TextUtils.isEmpty(edGender.getText().toString())) {
            setResult(RESULT_OK);
            Log.d(TAG,"setResult");
            SharedPreferences pref = getSharedPreferences("GENDER", MODE_PRIVATE);
            pref.edit()
                    .putString("edGender", useGender)
                    .apply();
            Log.d(TAG,"PREF");
            finish();
            Log.d(TAG,"finish");
        }
    }
}
