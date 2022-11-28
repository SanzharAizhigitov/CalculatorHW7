package com.geektech.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer first, second, result = 0;
    TextView textView;
    boolean isOperationClick;
    Operetion operetion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Button button = findViewById(R.id.perexod);
        button.setOnClickListener(view -> {
            intent.putExtra("key", result.toString());
            startActivity(intent);

        });
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("1");
                } else {
                    textView.append("1");
                }
                break;
            case R.id.two:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("2");
                } else {
                    textView.append("2");
                }
                break;
            case R.id.three:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("3");
                } else {
                    textView.append("3");
                }
                break;
            case R.id.four:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("4");
                } else {
                    textView.append("4");
                }
                break;
            case R.id.five:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("5");
                } else {
                    textView.append("5");
                }
                break;
            case R.id.six:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("6");
                } else {
                    textView.append("6");
                }
                break;
            case R.id.seven:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("7");
                } else {
                    textView.append("7");
                }
                break;
            case R.id.eight:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("8");
                } else {
                    textView.append("8");
                }
                break;
            case R.id.nine:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("9");
                } else {
                    textView.append("9");
                }
                break;
            case R.id.zero:
                if (textView.getText().toString().equals("0") || isOperationClick) {
                    textView.setText("0");
                } else {
                    textView.append("0");
                }
                break;
            case R.id.AC:
                textView.setText("0");
                first = 0;
                second = 0;
        }
        isOperationClick = false;
        ((Button) findViewById(R.id.perexod)).setVisibility(View.GONE);
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                first = Integer.valueOf(textView.getText().toString());
                operetion = Operetion.PLUS;
                ((Button) findViewById(R.id.perexod)).setVisibility(View.GONE);
                break;
            case R.id.minus:
                first = Integer.valueOf(textView.getText().toString());
                operetion = Operetion.MINIS;
                ((Button) findViewById(R.id.perexod)).setVisibility(View.GONE);
                break;
            case R.id.delit:
                operetion = Operetion.DELIT;
                ((Button) findViewById(R.id.perexod)).setVisibility(View.GONE);
                first = Integer.valueOf(textView.getText().toString());
                break;
            case R.id.multipli:
                operetion = Operetion.MULTIPLY;
                ((Button) findViewById(R.id.perexod)).setVisibility(View.GONE);
                first = Integer.valueOf(textView.getText().toString());
                break;
            case R.id.ravna:
                if (operetion == Operetion.PLUS) {
                    second = Integer.valueOf(textView.getText().toString());
                    result = first + second;
                    textView.setText(result.toString());
                } else if (operetion == Operetion.MINIS) {
                    second = Integer.valueOf(textView.getText().toString());
                    result = first - second;
                    textView.setText(result.toString());
                } else if (operetion == Operetion.DELIT) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "При делении остаток удаляется", Toast.LENGTH_SHORT);
                    toast.show();
                    second = Integer.valueOf(textView.getText().toString());
                    result = first / second;
                    textView.setText(result.toString());
                }
                if (operetion == Operetion.MULTIPLY) {
                    second = Integer.valueOf(textView.getText().toString());
                    result = first * second;
                    textView.setText(result.toString());
                }

                ((Button) findViewById(R.id.perexod)).setVisibility(View.VISIBLE);
                break;
        }
        isOperationClick = true;
    }
}
