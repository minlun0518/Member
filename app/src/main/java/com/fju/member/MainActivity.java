package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;
    boolean showNikename =false;

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
        TextView name =findViewById(R.id.nameTextView);
        TextView age =findViewById(R.id.ageTextView);
        TextView gender =findViewById(R.id.genderEd);

        //String username = edUser.getText().toString();

        //getSharedPreferences("member",MODE_PRIVATE);
        //SharedPreferences pref = getSharedPreferences("example", MODE_PRIVATE);
        String userid = getSharedPreferences("example", MODE_PRIVATE)
                .getString("nickname", "");

    }
}
