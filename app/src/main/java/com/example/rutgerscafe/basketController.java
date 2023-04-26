package com.example.rutgerscafe;

//import static com.example.rutgerscafe.StoreOrderController.StoreOrderList;
//import static com.example.rutgerscafe.StoreOrderController.total_amount;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class basketController extends AppCompatActivity {

    public static double subtotal = 0;
    public double total = 0;
    public double salesTax = 0;
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    EditText subtotalTextBox, totalTextBox, taxTextbox;


    private double costRemoved = 0;

    private static double TAX_AMOUNT = 0.07;
    private ArrayAdapter<String> adapter;


    public static ArrayList<String> order = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        //StoreOrderList.add(order);
        //total_amount.add(2.00);

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

        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(basketController.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + position);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String removedItem = order.get(positionToRemove);
                        order.remove(positionToRemove);

                        String cleanedItem = removedItem.replaceAll("\\D+", "");
                        costRemoved = (Double.parseDouble(cleanedItem)) * .01;


                        subtotal = subtotal - costRemoved;
                        salesTax = subtotal * TAX_AMOUNT;
                        total = subtotal + salesTax;

                        subtotalTextBox.setText("$" +moneyFormat.format(subtotal) + "");
                        totalTextBox.setText("$" + moneyFormat.format(total) + "");
                        taxTextbox.setText("$" +moneyFormat.format(salesTax) + "");

                        adapter.notifyDataSetChanged();


                    }
                });
                adb.show();
            }
        });
    }

}