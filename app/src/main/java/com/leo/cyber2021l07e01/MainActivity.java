package com.leo.cyber2021l07e01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FORMAT_STR = "%.10f";

    private EditText etDisplay;

    private enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private Operator op;
    private double num1, num2, lastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = Double.NaN;
        num2 = Double.NaN;
        lastResult = Double.NaN;

        etDisplay = findViewById(R.id.etDisplay);
    }

    private double input;
    private boolean getInput() {
        String dispStr = etDisplay.getText().toString();
        // if there's nothing entered, don't do anything
        if (dispStr.trim().isEmpty()) {
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
            return false;
        }
        input = Double.parseDouble(dispStr);
        return true;
    }

    public void onClick_opAdd(View view) {

    }

    public void onClick_opSub(View view) {

    }

    public void onClick_opMul(View view) {

    }

    public void onClick_opDiv(View view) {

    }

    public void onClick_clear(View view) {

    }

    public void onClick_equ(View view) {

    }

    public void onClick_credits(View view) {
        Intent i = new Intent(this, CreditsActivity.class);
        i.putExtra("lastResult", lastResult);
        startActivity(i);
    }
}
