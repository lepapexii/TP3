package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tp3.MESSAGE";
    public SharedPreferences mspNom, mspPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void methodeClic(View v){

        EditText userName = findViewById(R.id.nomInput);
        String userNameText = userName.getText().toString();

        EditText password = findViewById(R.id.passwordInput);
        String passwordText = password.getText().toString();
        if(passwordText != "12345"){
            badPassword("l’accès n’est pas autorisé");
        }else{
            goodPassword(userNameText);
        }
    }

    public void badPassword(String password){
        Intent intent = new Intent(this, BadPassword.class);
        intent.putExtra(EXTRA_MESSAGE, password);
        startActivity(intent);
    }

    public void goodPassword(String usager){
        Intent intent = new Intent(this, GoodPassword.class);
        intent.putExtra(EXTRA_MESSAGE, usager);
        startActivity(intent);
    }

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
