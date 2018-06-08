package com.example.android.hangman_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loseActivity extends AppCompatActivity {
    TextView a;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        Intent obj = getIntent();
        String correct = obj.getStringExtra("correct_word");
        a =findViewById(R.id.correctword);
        a.setText(correct);
        bt1 = findViewById(R.id.quitbtn1);
        bt2 = findViewById(R.id.playagainbtn);
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
                Intent mainactivity1 = new Intent(loseActivity.this,MainActivity.class);
                startActivity(mainactivity1);
            }
        });
    }
}
