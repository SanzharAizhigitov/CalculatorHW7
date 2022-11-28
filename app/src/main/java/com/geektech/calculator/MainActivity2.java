package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main2);
        MaterialButton button = findViewById(R.id.delete);
        button.setOnClickListener(view -> {
             finishAffinity();
        });
        TextView textView = findViewById(R.id.resultat);
        textView.setText(getIntent().getStringExtra("key"));
    }
}