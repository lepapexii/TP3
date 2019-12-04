package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CarteYohan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_yohan);
    }

    public void click(View v){

        EditText nv = findViewById(R.id.score);
        int note = Integer.parseInt(nv.getText().toString()) ;

        Intent intent = new Intent(this, GoodPassword.class);

        MainActivity.tabResultat[1] = note;
        startActivity(intent);

    }
}
