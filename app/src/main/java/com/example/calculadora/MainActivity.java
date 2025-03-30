package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import model.Operador;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    private Button buttonClear, buttonPlus, buttonEquals, buttonMinus, buttonMult, buttonDiv, buttonPoint;
    private Operador operador;
    private Double operando;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        buttonClear = findViewById(R.id.buttonClear);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMult = findViewById(R.id.buttonMult);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonPoint = findViewById(R.id.buttonPoint);
        checkBox = findViewById(R.id.checkBox);


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operando = Double.parseDouble(display.getText().toString());
                operador = Operador.SUMA;
                display.setText("0");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operando = Double.parseDouble(display.getText().toString());
                operador = Operador.RESTA;
                display.setText("0");
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operando = Double.parseDouble(display.getText().toString());
                operador = Operador.MULTIPLICACION;
                display.setText("0");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operando = Double.parseDouble(display.getText().toString());
                operador = Operador.DIVISION;
                display.setText("0");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().contains(".")) {
                    display.setText(display.getText().toString() + ".");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double operando2 = Double.parseDouble(display.getText().toString());
                Double resultado = 0.0;
                if(operador == Operador.SUMA)
                    resultado = operando + operando2;
                else if (operador == Operador.RESTA)
                    resultado = operando - operando2;
                else if (operador == Operador.MULTIPLICACION)
                    resultado = operando * operando2;
                else if (operador == Operador.DIVISION){
                    if (operando2 != 0)
                        resultado = operando / operando2;
                    else
                        display.setText("Error");
                }
                display.setText(resultado.toString());
            }
        });

    }

    public void onClick(View view){
        if(display.getText().equals("0"))
            display.setText(((Button) view).getText());
        else
            display.setText(display.getText().toString() + ((Button) view).getText());
    }

}