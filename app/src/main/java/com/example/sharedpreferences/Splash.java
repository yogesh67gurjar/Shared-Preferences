package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.sharedpreferences.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {
ActivitySplashBinding binding;

SharedPreferences sharedPreferences;
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences=getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        // mode private means apne preferences doosri app use nhi kr skti
        // mode private nhi rkhwane ka case tb bnega jb apne paas 2 apps ho & ek app k preferences ka data doosri app me use krna ho or apn un dono me communication krwana chahte he
        // uske liye mode he MODE_ENABLE_WRITE_AHEAD_LOGGING

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  *yha pr this kaam nhi krega qki apn runnable class k andar he*

                //  yha pr apn shared preference se get krwa rhe he boolean value jiski key flag he
                //  agar shared preference me flag hoga to uski value jo hogi andar wo apn ko mil jaegi
                //  nhi to phir apn ne jo yha value daali he ie ("flag",false) wo mil jaegi
                //  lekin is line se shared preference me value put nhi hogi
                //  wo to tb hi hogi jb apn khud se put krenge
                if(sharedPreferences.getBoolean("flag",false))
                {
                    intent=new Intent(Splash.this,MainActivity.class);
                }
                else
                {
                    intent=new Intent(Splash.this,Login.class);
                }
                startActivity(intent);
                finish();
            }
        },2500);
    }
}