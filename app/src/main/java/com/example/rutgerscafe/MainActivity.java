package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * main activty page of app
 * @author Zhenglin Li, Adrian Mosquera
 */
public class MainActivity extends AppCompatActivity{
    Button coffeeButton, checkCartButton, donutButton, storeOrderButton;

    /**
     * everything initialized on opening of app
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeeButton = (Button) findViewById(R.id.coffeeButton);
        checkCartButton = (Button) findViewById(R.id.checkCartButton);
        donutButton = (Button) findViewById(R.id.donutButton);
        storeOrderButton = (Button) findViewById(R.id.storeOrderButton);

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            /**
             * opens coffee activity
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), coffeeController.class);
                startActivity(i);
            }
        });
        checkCartButton.setOnClickListener(new View.OnClickListener() {
            /**
             * opens cart activity
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), basketController.class);
                startActivity(i);
            }
        });

        donutButton.setOnClickListener(new View.OnClickListener(){
            /**
             * opens donut activity
             * @param V The view that was clicked.
             */
            @Override
            public void onClick(View V) {
                Intent i = new Intent(getApplicationContext(), DonutController.class);
                startActivity(i);
            }
        });
        storeOrderButton.setOnClickListener(new View.OnClickListener(){
            /**
             * opens store orders activity
             * @param V The view that was clicked.
             */
            @Override
            public void onClick(View V) {
                Intent i = new Intent(getApplicationContext(), StoreOrderController.class);
                startActivity(i);
            }
        });

    }

}