package com.leo.cyber2021l07e01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {

    private static final String FORMAT_STR = "Your last result was: %.10f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        TextView tvLastResult = findViewById(R.id.tvLastResult);

        Intent i = getIntent();
        double lr = i.getDoubleExtra("lastResult", Double.NaN);
        if (!Double.isNaN(lr))
            tvLastResult.setText(String.format(FORMAT_STR, lr));
    }

    public void onClick_return(View view) {
        finish(); // return to main activity
    }
}
