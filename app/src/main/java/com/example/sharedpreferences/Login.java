package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedpreferences.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
                editor = sharedPreferences.edit();

                editor.putBoolean("flag",true);
                editor.apply();
                // apn jb bhi editor ko use krte he to use krne k last me apply() ya commit() krna pdega

                startActivity(new Intent(Login.this,MainActivity.class));
                finish();
            }
        });
    }
}