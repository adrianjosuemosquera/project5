package com.example.rutgerscafe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class basketController extends AppCompatActivity {

    int subtotal = 0;
    int total = 0;
    int salesTax = 0;
    private ArrayAdapter<String> adapter;


    public static ArrayList<String> order = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        ListView orderList = (ListView) findViewById(R.id.orderViewListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order);

        orderList.setAdapter(adapter);

    }

}