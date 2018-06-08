package com.example.android.hangman_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class winActivity extends AppCompatActivity {
    Button bt1,bt2;
    static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        bt1=findViewById(R.id.quitbtn);
        bt2=findViewById(R.id.nextbtn);
        score++;
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainactivity = new Intent(winActivity.this,MainActivity.class);
                startActivity(mainactivity);
            }
        });
    }
}
