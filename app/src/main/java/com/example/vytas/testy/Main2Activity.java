package com.example.vytas.testy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int i = 0;
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.textView2);
        btn =  findViewById(R.id.start); /*pass button*/
        txt.setText("FUCK");

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                i=i+1;
                txt.setText("Dododo " +i);
            }
        });

    }
}


