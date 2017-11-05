package com.example.vytas.testy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    TextView ct;
    TextView txt; /*txt kaip kreipsimes i textview*/
    Button pass; /*kaip kreipsimes i mygtuka*/
    Button next;
    Button starty;
    Button rr;
    TextView task;

    final String[] zodziai = {"G", "B", "C", "D", "G2", "B2", "C2", "D2"};

    int index = 0;
    int nextd = 0;
    int passid = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        count();
    }


    public void game() {


        txt = (TextView) findViewById(R.id.textView); /*koks txt yra id*/
        pass = (Button) findViewById(R.id.passButton); /*koks pass yra id*/
        next = (Button) findViewById(R.id.nextButton);


        pass.setOnClickListener(new View.OnClickListener() { /*ziuri kada paspaudzia mygtuka*/
            @Override
            public void onClick(View view) {
                if (index != zodziai.length) {
                    txt.setText(zodziai[index]);
                    index++;
                    passid++;
                } else {
                    txt.setText("Out of words");
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index != zodziai.length) {
                    txt.setText(zodziai[index]);
                    index++;
                    nextd++;
                } else {
                    txt.setText("Out of words");
                }
            }
        });

        rr = (Button) findViewById(R.id.restart);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

    }

    public void count() {

        starty = (Button) findViewById(R.id.button2);
        ct = (TextView) findViewById(R.id.textCount);
        task = (TextView) findViewById(R.id.textView2);

        starty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                starty.setVisibility(View.GONE);
                game();
                txt.setText(zodziai[0]);
                new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        ct.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        txt.setVisibility(View.GONE);
                        task.setText("Game over \n Press restart \n Passes: " + passid + "\n Correct: " + nextd);
                        rr.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });

    }


}



