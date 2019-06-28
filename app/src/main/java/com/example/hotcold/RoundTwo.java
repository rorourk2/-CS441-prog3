package com.example.hotcold;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RoundTwo extends AppCompatActivity {
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_two);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent mIntent=getIntent();
        temp=mIntent.getIntExtra("the",0);

        final TextView t=(TextView) findViewById(R.id.textView);
        String L=Integer.toString(temp);
        L="It is "+L+"°C";
        t.setText(L);

        ImageView I1=findViewById(R.id.imageView2);
        ImageView I2=findViewById(R.id.imageView3);
        ImageView I3=findViewById(R.id.imageView4);
        ImageView I4=findViewById(R.id.imageView5);


        if(temp<4){
            I1.setVisibility(View.VISIBLE);
        }else if(temp<17){
            I2.setVisibility(View.VISIBLE);
        }else if(temp<30){
            I3.setVisibility(View.VISIBLE);
        }else{
            I4.setVisibility(View.VISIBLE);
        }



        Button fab = findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOtherActivity(temp);
            }
        });
    }

    public void startOtherActivity(int x){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("the2",x);
        startActivity(intent);
    }

}
