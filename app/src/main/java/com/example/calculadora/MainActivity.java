package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import model.Operador;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    private Button buttonClear, buttonPlus, buttonEquals;
    private Operador operador;
    private Double operando;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        buttonClear = findViewById(R.id.buttonClear);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPlus = findViewById(R.id.buttonPlus);

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

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double operando2 = Double.parseDouble(display.getText().toString());
                Double resultado = 0.0;
                if(operador == Operador.SUMA)
                    resultado = operando + operando2;
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