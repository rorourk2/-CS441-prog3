package com.example.hotcold;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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




        FloatingActionButton fab = findViewById(R.id.fab);
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
