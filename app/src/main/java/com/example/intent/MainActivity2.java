package com.example.intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.intent.MainActivity.NAME_KEY;
import static com.example.intent.MainActivity.RANDOM_KEY;
public class MainActivity2 extends AppCompatActivity {
    Button btn;
    TextView tv;
    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.second_btn_share);
        tv = findViewById(R.id.second_tv_res);
        Intent intent = getIntent();
        tv.setText(intent.getStringExtra(RANDOM_KEY));
        String message = "Hi "+intent.getStringExtra(NAME_KEY)+", your lucky number is "+intent.getStringExtra(RANDOM_KEY)+'.';
        btn.setOnClickListener(
                v -> {
                    Intent intent1 = new Intent(Intent.ACTION_SEND);
                    intent1.setType("text/plain");
                    intent1.putExtra(Intent.EXTRA_TEXT,message);
                    startActivity(Intent.createChooser(intent1, "Share via"));
                }
        );
    }
}