package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import model.Operador;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    private Button buttonClear, buttonPlus, buttonEquals, buttonMinus, buttonMult, buttonDiv, buttonPoint;
    private Operador operador;
    private Double operando;
    private CheckBox checkBox;
    private RadioButton radioPlus, radioMinus, radioMult, radioDiv;
    private RadioGroup radioGroup;


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
        radioPlus = findViewById(R.id.radioPlus);
        radioMinus = findViewById(R.id.radioMinus);
        radioMult = findViewById(R.id.radioMult);
        radioDiv = findViewById(R.id.radioDiv);
        radioGroup = findViewById(R.id.radioGroup);

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

        radioGroup.setVisibility(View.GONE);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    radioGroup.setVisibility(View.VISIBLE);
                } else {
                    radioGroup.setVisibility(View.GONE);
                    buttonPlus.setEnabled(true);
                    buttonMinus.setEnabled(true);
                    buttonMult.setEnabled(true);
                    buttonDiv.setEnabled(true);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioPlus) {
                    buttonPlus.setEnabled(false);
                    buttonMinus.setEnabled(true);
                    buttonMult.setEnabled(true);
                    buttonDiv.setEnabled(true);
                }
                if (checkedId == R.id.radioMinus) {
                    buttonPlus.setEnabled(true);
                    buttonMinus.setEnabled(false);
                    buttonMult.setEnabled(true);
                    buttonDiv.setEnabled(true);
                }
                if (checkedId == R.id.radioMult) {
                    buttonPlus.setEnabled(true);
                    buttonMinus.setEnabled(true);
                    buttonMult.setEnabled(false);
                    buttonDiv.setEnabled(true);
                }
                if (checkedId == R.id.radioDiv) {
                    buttonPlus.setEnabled(true);
                    buttonMinus.setEnabled(true);
                    buttonMult.setEnabled(true);
                    buttonDiv.setEnabled(false);
                }

            }
        });

        if (savedInstanceState!=null){
            display.setText(savedInstanceState.getString("display"));
        }

    }

    public void onClick(View view){
        if(display.getText().equals("0"))
            display.setText(((Button) view).getText());
        else
            display.setText(display.getText().toString() + ((Button) view).getText());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("display",display.getText().toString());

    }


}