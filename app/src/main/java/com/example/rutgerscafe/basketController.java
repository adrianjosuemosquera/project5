package com.example.rutgerscafe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class basketController extends AppCompatActivity {

    public static double subtotal = 0;
    public double total = 0;
    public double salesTax = 0;
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    EditText subtotalTextBox, totalTextBox, taxTextbox;

    private static double TAX_AMOUNT = 0.07;
    private ArrayAdapter<String> adapter;


    public static ArrayList<String> order = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        subtotalTextBox = (EditText) findViewById(R.id.subTotalOrderTextBox);
        taxTextbox = (EditText) findViewById(R.id.salesTaxOrderTextBox);
        totalTextBox = (EditText) findViewById(R.id.totalOrderTextBox);

        ListView orderList = (ListView) findViewById(R.id.orderViewListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order);


        subtotalTextBox.setText("$" +moneyFormat.format(subtotal) + "");

        salesTax = subtotal * TAX_AMOUNT;
        total = subtotal + salesTax;

        totalTextBox.setText("$" + moneyFormat.format(total) + "");
        taxTextbox.setText("$" +moneyFormat.format(salesTax) + "");


        orderList.setAdapter(adapter);

    }

}