package com.example.android.hangman_game;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myList = new ArrayList<>();
    ArrayList<Character> wrongWordEnter = new ArrayList<Character>();
    ArrayList<Character> rightWordEnter = new ArrayList<Character>();
    int count=0,winCount=0,Chances=10;
    int score=0,Bestscore=0;
    LinearLayout myLayout;
    LinearLayout myLayout1,wrong;
    TextView dash,dash1,wrongAttach,scor,Bestscor;
    Button ok;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int leng = wrongWordEnter.size();
        scor= findViewById(R.id.currentscore);
        Bestscor= findViewById(R.id.Bestscore);
        final MediaPlayer mp = MediaPlayer.create(MainActivity.this,R.raw.badsound);
        final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this,R.raw.goodsound);
        for(int i=0;i<leng;i++)
        {
            wrongWordEnter.remove(i);
        }
        myList.add("abruptly");
        myList.add("buffoon");
        myList.add("exodus");
        myList.add("queue");
        myList.add("jumbo");
        myList.add("gabby");
        myList.add("syndrome");
        myList.add("unknown");
        myList.add("rhythm");
        myList.add("whisky");
        myList.add("keyhole");
        myList.add("subway");
        myList.add("jackpot");
        myList.add("zipper");
        myList.add("transcript");
        myList.add("scratch");
        myList.add("luxury");
        myList.add("injury");
        myList.add("wrist");
        myList.add("watch");
        myList.add("romantic");
        myList.add("staff");
        myList.add("compliment");
        myList.add("jazz");
        myList.add("buzz");
        myList.add("hymn");
        Collections.shuffle(myList);
        final String word=returnWord();
        myLayout = findViewById(R.id.lineartext);
        for(int i=0;i<word.length();i++)
        {
            dash = new TextView(MainActivity.this);
            dash.setBackgroundColor(getResources().getColor(R.color.black));
            dash.setWidth(80);
            dash.setHeight(5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,2,8,2);
            dash.setLayoutParams(params);
            myLayout.addView(dash);
        }
        myLayout1 = findViewById(R.id.lineartext1);
        for(int i=0;i<word.length();i++)
        {
            dash1 = new TextView(MainActivity.this);
            dash1.setWidth(80);
            dash1.setHeight(100);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(1,2,8,2);
            dash1.setLayoutParams(params);
            dash1.setGravity(Gravity.CENTER_VERTICAL);
            dash1.setGravity(Gravity.CENTER_HORIZONTAL);
            dash1.setId(i);
            dash1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20f);
            myLayout1.addView(dash1);
        }

        ok = findViewById(R.id.done_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit = findViewById(R.id.editText);
                wrong=findViewById(R.id.wrong_words);
                String guessLetter1= edit.getText().toString().toLowerCase().trim();
                if(guessLetter1.matches("")){
                    Toast.makeText(MainActivity.this,"PLEASE ENTER A LETTER",Toast.LENGTH_SHORT).show();
                }
                else{
                    String guessLetter=String.valueOf(guessLetter1.charAt(0));
                    edit.setText("");
                    if(guessLetter1.length()>1)
                    {
                        Toast.makeText(MainActivity.this,"ONLY ONE LETTER WILL BE CONSIDERED",Toast.LENGTH_SHORT).show();
                    }
                    int temp=winCount;
                    boolean cond=false;
                    Character a = guessLetter.charAt(0);
                    for(int i=0;i<word.length();i++)
                    {
                        if(rightWordEnter.contains(a))
                        {
                            cond=true;
                            break;
                        }
                        else if(guessLetter.equals(String.valueOf(word.charAt(i)))){
                            winCount++;
                            TextView letterSet = findViewById(i);
                            letterSet.setText(guessLetter);
                        }
                    }
                    if(cond){
                        Toast.makeText(MainActivity.this,"ALREADY DISCOVERED",Toast.LENGTH_SHORT).show();
                    }
                    else if(temp==winCount) {

                        mp.start();
                        Boolean condition = wrongWordEnter.contains(a);
                        if (condition) {
                            Toast.makeText(MainActivity.this,"THIS WORD IS ALREADY PRESENT IN LIST OF WRONG WORDS",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            ImageView hangman;
                            hangman = findViewById(R.id.img);
                            wrongWordEnter.add(a);
                            switch (Chances)
                            {
                                case 10:
                                    hangman.setImageResource(R.drawable.img1);
                                    break;
                                case 9:
                                    hangman.setImageResource(R.drawable.img2);
                                    break;
                                case 8:
                                    hangman.setImageResource(R.drawable.img3);
                                    break;
                                case 7:
                                    hangman.setImageResource(R.drawable.img4);
                                    break;
                                case 6:
                                    hangman.setImageResource(R.drawable.img5);
                                    break;
                                case 5:
                                    hangman.setImageResource(R.drawable.img6);
                                    break;
                                case 4:
                                    hangman.setImageResource(R.drawable.img7);
                                    break;
                                case 3:
                                    hangman.setImageResource(R.drawable.img8);
                                    break;
                                case 2:
                                    hangman.setImageResource(R.drawable.img9);
                                    break;
                                case 1:
                                    hangman.setImageResource(R.drawable.img10);
                                    break;
                            }
                            Chances--;
                            if(Chances==0){
                                Bestscore =Integer.parseInt(Bestscor.getText().toString().trim());
                                if(Bestscore<score)
                                {
                                    Bestscor.setText(Bestscore);
                                }
                                Intent loseintent = new Intent(MainActivity.this,loseActivity.class);
                                loseintent.putExtra("correct_word",word);
                                startActivity(loseintent);
                                finish();
                            }
                            else{
                                wrongAttach = new TextView(MainActivity.this);
                                wrongAttach.setWidth(150);
                                wrongAttach.setHeight(100);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                params.setMargins(4,2,4,2);
                                wrongAttach.setLayoutParams(params);
                                wrongAttach.setTextColor(getResources().getColor(R.color.red));
                                wrongAttach.setText(guessLetter);
                                wrongAttach.setGravity(Gravity.CENTER_VERTICAL);
                                wrongAttach.setGravity(Gravity.CENTER_HORIZONTAL);
                                wrongAttach.setTextSize(TypedValue.COMPLEX_UNIT_SP,25f);
                                wrong.addView(wrongAttach);
                            }
                        }
                    }
                    else if(winCount>temp){
                        mp1.start();
                        rightWordEnter.add(a);
                        if(winCount==word.length()){
                            score++;
                            scor.setText(score+"");
                            Intent winintent = new Intent(MainActivity.this,winActivity.class);
                            startActivity(winintent);
                            finish();
                        }
                    }
                }
            }
        });

    }
    public String returnWord()
    {
        String word;
        if(count==25)
        {
            word=myList.get(count);
            count=0;
            Collections.shuffle(myList);
        }
        else{
            word=myList.get(count);
            count++;
        }
        return word;
    }
}


