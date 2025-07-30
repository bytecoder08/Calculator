package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, divide, percent, equals, backspace,double_zero,clear,point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.c1);
        two = findViewById(R.id.c2);
        three = findViewById(R.id.c3);
        four = findViewById(R.id.c4);
        five = findViewById(R.id.c5);
        six = findViewById(R.id.c6);
        seven = findViewById(R.id.c7);
        eight = findViewById(R.id.c8);
        nine = findViewById(R.id.c9);
        zero = findViewById(R.id.c0);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        percent = findViewById(R.id.percent);
        equals = findViewById(R.id.equals);
        backspace = findViewById(R.id.backspace);
        double_zero = findViewById(R.id.c00);
        clear = findViewById(R.id.clear);
        point = findViewById(R.id.point);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}