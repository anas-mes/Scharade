package com.example.scharade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {
    TextView team1;
    TextView team2;
    ImageButton start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        team1=findViewById(R.id.team1);
        team2=findViewById(R.id.team2);
        start_button=findViewById(R.id.start_button);
        ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("list");
        for(int i =0;i<list.size();i++){
            if(i%2==0){
                team1.append(list.get(i));
                team1.append("\n");

            }else{
                team2.append(list.get(i));
                team2.append("\n");

            }
        }
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamActivity.this, Game.class);
                startActivity(intent);
            }
        });

    }
}
