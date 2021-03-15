package com.example.calculatorvariation.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculatorvariation.R;
import com.example.calculatorvariation.domain.CalculatorImpl;
import com.example.calculatorvariation.domain.Operation;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity implements ICalculatorView {

    private final CalculatorPresenter presenter = new CalculatorPresenter(this, this, new CalculatorImpl());
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = findViewById(R.id.result);

        Map<Integer, Integer> digitsMap = new HashMap<>();

        digitsMap.put(R.id.button_1, 1);
        digitsMap.put(R.id.button_2, 2);
        digitsMap.put(R.id.button_3, 3);
        digitsMap.put(R.id.button_4, 4);
        digitsMap.put(R.id.button_5, 5);
        digitsMap.put(R.id.button_6, 6);
        digitsMap.put(R.id.button_7, 7);
        digitsMap.put(R.id.button_8, 8);
        digitsMap.put(R.id.button_9, 9);
        digitsMap.put(R.id.button_0, 0);

        View.OnClickListener digitCLickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.digitalKeyPressed(digitsMap.get(view.getId()));
            }
        };

        findViewById(R.id.button_1).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_2).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_3).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_4).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_5).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_6).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_7).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_8).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_9).setOnClickListener(digitCLickListener);
        findViewById(R.id.button_0).setOnClickListener(digitCLickListener);

        Map<Integer, Operation> operatorsMap = new HashMap<>();

        operatorsMap.put(R.id.button_div, Operation.DIV);
        operatorsMap.put(R.id.button_mult, Operation.MULT);
        operatorsMap.put(R.id.button_plus, Operation.ADD);
        operatorsMap.put(R.id.button_minus, Operation.SUB);

        View.OnClickListener operatorCLickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.operatorKeyPressed(operatorsMap.get(view.getId()));
            }
        };

        findViewById(R.id.button_div).setOnClickListener(operatorCLickListener);
        findViewById(R.id.button_mult).setOnClickListener(operatorCLickListener);
        findViewById(R.id.button_plus).setOnClickListener(operatorCLickListener);
        findViewById(R.id.button_minus).setOnClickListener(operatorCLickListener);

        findViewById(R.id.button_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.dotPressed();
            }
        });

        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.equalsPressed();
            }
        });
    }

    @Override
    public void displayResult(String s) {
        result.setText(s);
    }
}