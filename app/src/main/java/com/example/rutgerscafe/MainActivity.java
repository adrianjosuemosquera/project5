package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button coffeeButton, checkCartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeeButton = (Button) findViewById(R.id.coffeeButton);
        checkCartButton = (Button) findViewById(R.id.checkCartButton);

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), coffeeController.class);
                startActivity(i);
            }
        });

        checkCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), basketController.class);
                startActivity(i);
            }
        });

    }

}