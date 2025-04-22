package com.example.imadg42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz4Activity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect="Le tramway est arrêté";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        rg= findViewById(R.id.rg);
        bNext= findViewById(R.id.bNext);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;
        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
        bNext.setOnClickListener(v -> {
            rb= findViewById(rg.getCheckedRadioButtonId());
            if(rg.getCheckedRadioButtonId()==-1){
                Toast.makeText(getApplicationContext(),"Merci de choisir une réponse S.V.P !",Toast.LENGTH_SHORT).show();
            }
            else {
                //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                if(rb.getText().toString().equals(RepCorrect)){
                    score+=1;
                    //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                }
                Intent intent1 =new Intent(Quiz4Activity.this,Quiz5Activity.class);
                intent1.putExtra("score",score);
                startActivity(intent1);
                //overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                overridePendingTransition(R.anim.exit,R.anim.entry);
                finish();
            }

        });

    }
}
