package com.example.rutgerscafe;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Button;
import android.widget.Toast;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class StoreOrderController extends AppCompatActivity {

    public static ArrayList<ArrayList<String>> StoreOrderList = new ArrayList<>();
    public static ArrayList<Double> total_amount = new ArrayList<>();
    private Spinner order_number;
    private ListView order_contents;
    private TextView sub_total;
    private Button cancel_order;
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
        addOrderList();
        
        order_number.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displayOrder(position);
                sub_total.setText("$"+ moneyFormat.format(total_amount.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cancel_order = findViewById(R.id.cancel_button);

        cancel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(StoreOrderController.this);
                adb.setTitle("Cancel Order");
                adb.setMessage("Are you sure you want to order?");
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedOrder = (String) order_number.getSelectedItem();
                        int position = Integer.parseInt(selectedOrder.replaceAll("[^\\d]", ""));;
                        StoreOrderList.remove(position-1);
                        total_amount.remove(position-1);

                        ((BaseAdapter)order_number.getAdapter()).notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Order has been removed from the store.", Toast.LENGTH_LONG).show();
                    }
                });
                adb.show();
            }
        });
    }

    public void addOrderList(){
        int size = StoreOrderList.size();
        order_number = findViewById(R.id.order_number);
        sub_total = findViewById(R.id.total_amount);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for(int i=0; i<size; i++){
            adapter.add("order "+(i+1));
        }
        order_number.setAdapter(adapter);
    }

    public void displayOrder(int orderNumber){
        order_contents = findViewById(R.id.store_order_item_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, StoreOrderList.get(orderNumber));
        order_contents.setAdapter(adapter);
    }
}
