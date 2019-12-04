package com.example.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tp3.MESSAGE";
    public SharedPreferences mspNom, mspPass, note;
    TextView newNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newNote = findViewById(R.id.note);
        note = getPreferences(Context.MODE_PRIVATE);
        int ok = note.getInt("note",0);
        String str=Integer.toString(ok);
        newNote.setText(str);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        note = getPreferences(Context.MODE_PRIVATE);
        int ok = note.getInt("note",0);
        String str=Integer.toString(ok);
        newNote.setText(str);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        note = getPreferences(Context.MODE_PRIVATE);
        int ok = note.getInt("note",0);
        String str=Integer.toString(ok);
        newNote.setText(str);

    }

    public void methodeClic(View v){

        EditText userName = findViewById(R.id.nomInput);
        String userNameText = userName.getText().toString();

        EditText password = findViewById(R.id.passwordInput);
        String passwordText = password.getText().toString();
        if(!passwordText.equals("12345")){
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

    public void setNote() {

        newNote.setText(MainActivity.getDefaults("note",this));
    }

    public static void setDefaults(String key, int value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key,0);
    }
}
