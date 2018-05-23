package com.example.stivosha.clicker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button newGame = findViewById(R.id.newGame);
        Button loadGame = findViewById(R.id.load);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainGame.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getSharedPreferences("save1",MODE_PRIVATE);
                int money = sPref.getInt("money",0);
                int bonus = sPref.getInt("bonus",1);
               //Log.e("1",String.valueOf(money));
                Intent intent = new Intent(MainActivity.this, MainGame.class);
                intent.putExtra("money", money);
                intent.putExtra("bonus",bonus);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }

}
