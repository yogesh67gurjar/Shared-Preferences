package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferences.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("flag", false);
                editor.apply();
                // apn jb bhi editor ko use krte he to use krne k last me apply() ya commit() krna pdega
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });

        binding.putDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // yha apn sharedPreferences me hr type ka jis jis bhi type ka data possible he daalna wo daal rhe he

                Set<String> stringSet = new HashSet<>();
                stringSet.add("yogesh");
                stringSet.add("gurjar");

                editor.putInt("int", 1);
                editor.putBoolean("boolean", true);
                editor.putFloat("float", 3.14159f);
                editor.putLong("long", 1234567);
                editor.putString("string", "yogesh");
                editor.putStringSet("stringSet", stringSet);
                editor.apply();

                Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        binding.deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // yha apn hr trh ka data delete kr rhe he


                if (sharedPreferences.contains("int")) {

                    editor.remove("int");
                    editor.remove("boolean");
                    editor.remove("float");
                    editor.remove("long");
                    editor.remove("string");
                    editor.remove("stringSet");
                    editor.apply();

                    Toast.makeText(MainActivity.this, "deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}