package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputText, resultText;
    private String input = "";
    private double firstNumber = 0, secondNumber = 0;
    private char operator;
    private boolean operatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências aos TextViews
        inputText = findViewById(R.id.inputText);
        resultText = findViewById(R.id.resultText);

        // Referências aos botões numéricos
        int[] numberButtons = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9
        };

        View.OnClickListener numberClickListener = v -> {
            Button b = (Button) v;
            input += b.getText().toString();
            inputText.setText(input);
        };

        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(numberClickListener);
        }

        // Operadores
        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator('/'));

        // Botão ponto
        findViewById(R.id.btnDot).setOnClickListener(v -> {
            if (!input.contains(".")) {
                input += ".";
                inputText.setText(input);
            }
        });

        // Botão limpar
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());

        // Botão igual
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculate());
    }

    private void setOperator(char op) {
        if (!input.isEmpty()) {
            firstNumber = Double.parseDouble(input);
            operator = op;
            operatorPressed = true;
            input = "";
            inputText.setText(firstNumber + " " + op);
            resultText.setText("");
        }
    }

    private void calculate() {
        if (operatorPressed && !input.isEmpty()) {
            secondNumber = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case '+': result = firstNumber + secondNumber; break;
                case '-': result = firstNumber - secondNumber; break;
                case '*': result = firstNumber * secondNumber; break;
                case '/':
                    if (secondNumber == 0) {
                        resultText.setText("Erro");
                        return;
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
            }

            resultText.setText(String.valueOf(result));
            inputText.setText(firstNumber + " " + operator + " " + secondNumber);
            input = "";
            operatorPressed = false;
        }
    }

    private void clear() {
        input = "";
        firstNumber = 0;
        secondNumber = 0;
        operatorPressed = false;
        inputText.setText("");
        resultText.setText("");
    }
}
