package com.leo.cyber2021l07e01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

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

        etDisplay = findViewById(R.id.etDisplay);

        reset();
        lastResult = NaN;
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

    private void calculate(Operator newOp) {
        if (isNaN(num1)) {
            if (newOp == null)
                return;
            if (!getInput())
                return;
            num1 = input;
            op = newOp;
            etDisplay.setText("");
            return;
        } else if (isNaN(num2)) {
            if (!getInput())
                return;
            num2 = input;
            if (op == null && newOp != null)
                op = newOp;
            etDisplay.setText("");
        }
        switch (op) {
            case ADD:
                lastResult = num1 + num2;
                break;
            case SUBTRACT:
                lastResult = num1 - num2;
                break;
            case MULTIPLY:
                lastResult = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    num2 = NaN;
                    Toast.makeText(this, "Can't divide by zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                lastResult = num1 / num2;
                break;
            default:
                Toast.makeText(this, "Operation not chosen??", Toast.LENGTH_SHORT).show();
                return;
        }
        op = newOp;
        num2 = NaN;
        String resStr = String.format(FORMAT_STR, lastResult);
        if (op == null) {
            num1 = NaN;
            etDisplay.setText(resStr);
            etDisplay.setHint("");
        } else {
            num1 = lastResult;
            etDisplay.setText("");
            etDisplay.setHint(resStr);
        }
    }

    private void reset() {
        op = null;
        num1 = NaN;
        num2 = NaN;
        etDisplay.setText("");
    }

    public void onClick_opAdd(View view) {
        calculate(Operator.ADD);
    }

    public void onClick_opSub(View view) {
        calculate(Operator.SUBTRACT);
    }

    public void onClick_opMul(View view) {
        calculate(Operator.MULTIPLY);
    }

    public void onClick_opDiv(View view) {
        calculate(Operator.DIVIDE);
    }

    public void onClick_clear(View view) {
        reset();
    }

    public void onClick_equ(View view) {
        calculate(null);
    }

    public void onClick_credits(View view) {
        Intent i = new Intent(this, CreditsActivity.class);
        i.putExtra("lastResult", lastResult);
        startActivity(i);
    }
}
