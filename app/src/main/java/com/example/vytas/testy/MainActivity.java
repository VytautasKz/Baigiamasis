package com.example.vytas.testy;

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txt; /*txt kaip kreipsimes i textview*/
    Button pass; /*kaip kreipsimes i mygtuka*/
    Button next;
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        game();
    }

    public void game() {
        final String[] zodziai = {"G", "B", "C", "D"};

        txt = (TextView) findViewById(R.id.textView); /*koks txt yra id*/
        pass = (Button) findViewById(R.id.passButton); /*koks pass yra id*/
        next = (Button) findViewById(R.id.nextButton);



        pass.setOnClickListener(new View.OnClickListener() { /*ziuri kada paspaudzia mygtuka*/
            @Override
            public void onClick(View view) {
                if(index != zodziai.length) {
                    txt.setText(zodziai[index]);
                    index++;
                }else{
                    txt.setText("Out of text");
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int index1 = r.nextInt(zodziai.length);
                txt.setText(zodziai[index1]);
            }
        });
    }
}


