package com.example.btlan1_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tvOrderHeader, tvOrderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initial();

        Intent intent = getIntent();
        String value = intent.getStringExtra("Key_1");
        tvOrderDetail.setText("Taco - " + value);
    }

    private void initial() {
        tvOrderHeader = findViewById(R.id.textViewHeader);
        tvOrderDetail = findViewById(R.id.textViewOrderDetail);
    }
}