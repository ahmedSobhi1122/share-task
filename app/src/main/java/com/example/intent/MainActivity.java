package com.example.intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Editable e;
    EditText et;
    public static final String NAME_KEY = "name key";
    public static final String RANDOM_KEY = "random key";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.main_btn_share);
        et = findViewById(R.id.main_et_name);
        btn.setOnClickListener(
                v -> {
                    e = et.getText();
                    if (e.toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra(NAME_KEY, e.toString());
                        intent.putExtra(RANDOM_KEY, "" + Math.round(Math.random() * 1000));
                        startActivity(intent);
                    }
                }
        );
    }
}