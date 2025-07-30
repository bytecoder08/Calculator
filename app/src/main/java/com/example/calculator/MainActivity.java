package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    StringBuilder expression = new StringBuilder();
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, divide, percent, equals, backspace,double_zero,clear,point;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //textview
        textView = findViewById(R.id.textview);

        //buttons
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

        //input listeners
        setInputListener(one, "1");
        setInputListener(two, "2");
        setInputListener(three, "3");
        setInputListener(four, "4");
        setInputListener(five, "5");
        setInputListener(six, "6");
        setInputListener(seven, "7");
        setInputListener(eight, "8");
        setInputListener(nine, "9");
        setInputListener(zero, "0");
        setInputListener(double_zero, "00");
        setInputListener(point, ".");
        setInputListener(plus, "+");
        setInputListener(minus, "-");
        setInputListener(multiply, "*");
        setInputListener(divide, "/");
        setInputListener(percent, "%");

        clear.setOnClickListener(v->{
            expression.setLength(0);
            textView.setText("");

        });

        backspace.setOnClickListener(v->{
            if (expression.length() > 0) {
                expression.deleteCharAt(expression.length() - 1);
                textView.setText(expression.toString());
            }
        });

        equals.setOnClickListener(v->{

            String result = calculate(expression.toString());
            textView.setText(result);
            expression.setLength(0);
            expression.append(result);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setInputListener(Button button, String value) {
        button.setOnClickListener(v -> {
            expression.append(value);
            textView.setText(expression.toString());
        });
    }

    private String calculate(String expression) {

        try {
            double result = Calc.evaluate(expression);
            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }

    }
}