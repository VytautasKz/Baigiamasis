package com.example.vytas.testy;

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        game();
    }

    public void game(){
        final String[] zodziai = {"G", "B", "C", "D"};

        txt=(TextView) findViewById(R.id.textView);
        start=(Button) findViewById(R.id.passButton);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                for(int i = 0; i < zodziai.length; i++)
                txt.setText(zodziai[i]);
            }
        });

    }
}


