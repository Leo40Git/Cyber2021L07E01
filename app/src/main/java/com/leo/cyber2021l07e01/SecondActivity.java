package com.leo.cyber2021l07e01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvOut = findViewById(R.id.tvOut);

        Intent i = getIntent();
        tvOut.setText(i.getStringExtra("text"));
    }

    public void onClick_return(View view) {
        finish(); // return to main activity
    }
}
