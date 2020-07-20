package com.example.fibonacciseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        //onButton click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(fibonacci(Integer.parseInt(editText.getText().toString())));
            }
        });
    }

    //initialization done here
    private void initUI() {
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
    }

    //fibonacci series calculation
    private String fibonacci(int n) {
        String text = "";
        ArrayList<BigInteger> fib = new ArrayList<>();
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");

        fib.add(first);
        fib.add(second);

        //for loop
        for (int i = 1; i < n; i++) {
            fib.add(fib.get(i).add(fib.get(i - 1)));
        }

        for (int i = 1; i <= n; i++) {
            text = text + i + " - " + fib.get(i) + "\n";
        }
        return text;
    }
}
