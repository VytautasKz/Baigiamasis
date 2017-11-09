package com.example.vytas.testy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ct;
    TextView txt; /*txt kaip kreipsimes i textview*/
    Button pass; /*kaip kreipsimes i mygtuka*/
    Button next;
    Button starty;
    Button rr;
    TextView task;
    Button button5;
    Button button;
    TextView sm;
    TextView roundT;
    TextView textView3;

    final String[] zodziai = {"Pastatas", "Ligonine", "Prezidente", "Automobilis", "Kompiuteris", "Klaviatura", "Pele", "Programavimas"};

    int index = 0;
    int nextd = 0;
    int passid = 0;
    int nextd2 = 0;
    int passid2 = 0;
    boolean mode = false;
    int modeT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        team();
    }


    public void game() {

        index = 0;
        passid = 0;
        nextd = 0;

        txt = findViewById(R.id.textView); /*koks txt yra id*/
        pass = findViewById(R.id.passButton); /*koks pass yra id*/
        next = findViewById(R.id.nextButton);

        pass.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);

        pass.setOnClickListener(new View.OnClickListener() { /*ziuri kada paspaudzia mygtuka*/
            @Override
            public void onClick(View view) {
                index++;
                if (index <= zodziai.length) {
                    txt.setText(zodziai[index]);
                        passid++;
                    if (zodziai[index] == zodziai[zodziai.length - 1]) {
                        txt.setText(zodziai[index]);
                        index++;
                            passid++;
                    }
                } else if (index > zodziai.length) {
                    txt.setText("Out of words");

                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index <= zodziai.length) {
                    txt.setText(zodziai[index]);
                        nextd++;
                    if (zodziai[index] == zodziai[zodziai.length - 1]) {
                        txt.setText(zodziai[index]);
                        index++;
                            nextd++;
                    }
                } else if (index > zodziai.length) {
                    txt.setText("Out of words");
                }
            }
        });

        rr = findViewById(R.id.restart);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }

    public void count() {


        game();
        txt.setText(zodziai[index]);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                ct.setText("Round ends in: " + millisUntilFinished / 1000);
                if (txt.getText().toString().matches("Out of words")) {
                    ct.setVisibility(View.GONE);
                    ct = txt;
                }
            }

            public void onFinish() {
                ct.setVisibility(View.GONE);
                txt.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                pass.setVisibility(View.GONE);
                if(mode != true) {
                    task.setText("Game over \nPress restart \nPasses: " + passid + "\nCorrect: " + nextd);
                    rr.setVisibility(View.VISIBLE);
                } else if (mode == true){
                    if(modeT == 0) {
                        task.setText("Game over \nPress restart \n Team 1 points: \nPasses: " + passid + "\nCorrect: " + nextd);
                    } else if (modeT == 1) {
                        task.setText("Game over \nPress restart \n Team 2 points: \nPasses: " + passid2 + "\nCorrect: " + nextd2 +"\n" +countPoint());
                        rr.setVisibility(View.VISIBLE);
                    }
                }
                if(modeT == 1 && mode == true){
                    roundT = findViewById(R.id.teamText);
                    new CountDownTimer(10000, 1000){

                        public void onTick(long millisUntilFinished){
                            roundT.setText("Team 2 get ready! \n Round begins in: " +millisUntilFinished /1000);
                        }
                        public void onFinish(){

//                            txt.setVisibility(View.GONE);
                            roundT.setVisibility(View.GONE);
                            modeT++;
                            count();
                        }
                    }.start();

                }
            }
        }.start();

    }

    public void countdown() {
        starty = findViewById(R.id.button2);
        ct = findViewById(R.id.textCount);
        task = findViewById(R.id.textView2);
        txt = findViewById(R.id.textView);

        starty.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);

        starty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starty.setVisibility(View.GONE);
                new CountDownTimer(5000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        if(mode == true){
                            txt.setText("You rebel. I warned you. \n Game begins in: " + millisUntilFinished / 1000);
                        } else {
                            txt.setText("Game begins in: " + millisUntilFinished / 1000);
                        }
                    }

                    public void onFinish() {

                        count();
                        modeT++;
                    }
                }.start();
            }
        });
    }

    public void team() {
        button5 = findViewById(R.id.button5);
        button = findViewById(R.id.button);
        sm = findViewById(R.id.sm);
        textView3 = findViewById(R.id.textView3);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode = false;
                button5.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                sm.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
                countdown();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mode = true;
                button5.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                sm.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
                countdown();
            }
        });
    }

    public String countPoint(){

        String points = null;
        if(nextd > nextd2){
            points = "Team 1 won!";
        }else if(nextd < nextd2){
            points = "Team 2 won!";
        }else if(nextd == nextd2){
            points = "It's a tie!";
        }

        return points;
    }
}



