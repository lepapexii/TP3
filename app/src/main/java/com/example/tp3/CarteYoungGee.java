package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CarteYoungGee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_young_gee);
    }

    public void click(View v){
        EditText nv = findViewById(R.id.score);
        int note = Integer.parseInt(nv.getText().toString()) ;

        Intent intent = new Intent(this, GoodPassword.class);

        MainActivity.tabResultat[2] = note;
        startActivity(intent);

    }
}
