package com.example.stivosha.clicker;

import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import static com.example.stivosha.clicker.MainGame.money;
import static com.example.stivosha.clicker.MainGame.bonus;

public class Background implements Runnable {

    private static MainGame mainActivity;

    Background(MainGame mainActivity){

        this.mainActivity = mainActivity;
    }
    @Override
    public void run() {
        while(true){
            money+= 1*bonus;
            mainActivity.addMoney();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                Log.e("1","error");
            }
        }
    }
}
