package com.example.tp3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoodPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Set the text on a TextView object using a resource ID
        ListView lv = findViewById(R.id.listView);
        lv.setClickable(false);
        TextView nom = findViewById(R.id.userName);
        nom.setText(message);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView choose = findViewById(R.id.choose);
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);
                choose.setText(selectedItem);
                // Display the selected item text on TextView

                if(selectedItem.contains("Philippe")){
                    Intent intent = new Intent(parent.getContext(), CartePhilippe.class);
                    startActivity(intent);
                }else if(selectedItem.contains("Emmanuel")) {
                    Intent intent = new Intent(parent.getContext(), CarteEmmanuel.class);
                    startActivity(intent);
                }else if(selectedItem.contains("Yohan")){
                    Intent intent = new Intent(parent.getContext(), CarteYohan.class);
                    startActivity(intent);
                }else if(selectedItem.contains("YoungGee")){
                    Intent intent = new Intent(parent.getContext(), CarteYoungGee.class);
                    startActivity(intent);
                }else if(selectedItem.contains("JoJo")){
                    Intent intent = new Intent(parent.getContext(), CarteJoJo.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void click(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
