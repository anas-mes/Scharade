package com.example.scharade;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> names = new ArrayList<String>();
    EditText name ;
    ListView list ;
    Button button ;
    Button shuffle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.addButton);
        name = findViewById(R.id.name);
        list = findViewById(R.id.list);
        shuffle = findViewById(R.id.schuffle);

        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String input = name.getText().toString();
                 if (names.contains(input)) {
                     Toast.makeText(getBaseContext(), "name is already in the list", Toast.LENGTH_LONG).show();

                 } else if (input.equals("")) {
                     Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
                 } else {
                     names.add(input);
                     name.getText().clear();
                     ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, names);
                     list.setAdapter(adapter);
                     findViewById((R.id.name));
                 }
             }
         }
         );
        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(names.size()<2){
                    Toast.makeText(getBaseContext(), "list must contain at least 2 players", Toast.LENGTH_LONG).show();
                }else{
                    Collections.shuffle(names);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, names);
                    list.setAdapter(adapter);
                    findViewById((R.id.name));
                    Intent intent = new Intent(MainActivity.this, TeamActivity.class);
                    intent.putExtra("list",names);
                    startActivity(intent);

                }
            }
        });
    }
}