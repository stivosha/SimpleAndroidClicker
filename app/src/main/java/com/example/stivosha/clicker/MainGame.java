package com.example.stivosha.clicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainGame extends AppCompatActivity {

    private TextView tv;
    public static int money ;
    public static  int bonus ;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        money = intent.getIntExtra("money",0);
        bonus = intent.getIntExtra("bonus",1);
        tv = findViewById(R.id.money);
        ImageView imageView = findViewById(R.id.coin);

        Background bg = new Background(this);
        Button btn = findViewById(R.id.button);

        Thread bg1 = new Thread(bg);
        bg1.start();
        final TextView tv1 = findViewById(R.id.cost);
        tv1.setText("Cost: "+String.valueOf(10*bonus*bonus));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money >=  10*bonus*bonus){
                    money-=10*bonus*bonus;
                    bonus+=1;
                    tv.setText("Money:"+String.valueOf(money));
                    tv1.setText("Cost: "+String.valueOf(10*bonus*bonus));
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money+=1;
                tv.setText("Money:"+String.valueOf(money));
            }
        });
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    public void saveData(){
        sPref = getSharedPreferences("save1",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("money",money);
        ed.putInt("bonus",bonus);
        //ed.commit();
        ed.apply();
        Toast.makeText(MainGame.this, "Saved",Toast.LENGTH_SHORT).show();

    }
    public void addMoney(){
        tv.setText("Money:"+String.valueOf(money));
    }
}
