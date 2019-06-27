package com.example.hotcold;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SeekBar bar=findViewById(R.id.seekBar);
        Button s=findViewById(R.id.button);
        Button B1=findViewById(R.id.button3);
        Button B2=findViewById(R.id.button2);

        final EditText t=(EditText)findViewById(R.id.editText);
        final EditText t2=(EditText)findViewById(R.id.editText2);


        t.setText("0");

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(t.getText().toString());
                double info=(double)(x*9/5)+32;
                String S=Integer.toString((int)info);


                if(x<0){
                    bar.setProgress(0);
                }else if(x>100){
                    bar.setProgress(100);
                }else{
                    bar.setProgress(x);
                }
                t2.setText(S);
                S=Integer.toString(x);
                t.setText(S);
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(t2.getText().toString());
                double info=(double)((x-32)*5/9);
                String S=Integer.toString((int)info);

                if(info<0){
                    bar.setProgress(0);
                }else if(info>100){
                    bar.setProgress(100);
                }else{
                    bar.setProgress((int)info);
                }
                t.setText(S);
                S=Integer.toString(x);
                t2.setText(S);
            }
        });


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progressValue=0;
            String C ="";
            double info;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue=progress;
                C=Integer.toString(progressValue);
                t.setText(C);
                info=(double)(progress*9/5)+32;
                C=Integer.toString((int)(info));
                t2.setText(C);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOtherActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startOtherActivity(){
        Intent intent = new Intent(this, RoundTwo.class);
        startActivity(intent);
    }
}
