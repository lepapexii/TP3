package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CartePhilippe extends AppCompatActivity {
    Double[] reel = new Double[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre3);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

    public void click(View v){

        EditText nv = findViewById(R.id.score);
        int note = Integer.parseInt(nv.getText().toString()) ;

        Intent intent = new Intent(this, GoodPassword.class);

        MainActivity.tabResultat[0] = note;
        startActivity(intent);


    }
}
