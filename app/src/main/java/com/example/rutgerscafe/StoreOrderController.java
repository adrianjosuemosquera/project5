package com.example.rutgerscafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreOrderController extends AppCompatActivity {

    public static ArrayList<ArrayList<String>> StoreOrderList = new ArrayList<>();
    public static ArrayList<Double> total_amount;
    private Spinner order_number;
    private ListView order_contents;
    private TextView sub_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
        addOrderList();
        
        order_number.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displayOrder(position);
                //sub_total.setText(Double.toString(total_amount.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing when nothing is selected
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
        adapter.add("order "+(0+1));
        order_number.setAdapter(adapter);
    }

    public void displayOrder(int orderNumber){
        order_contents = findViewById(R.id.store_order_item_list);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, StoreOrderList.get(orderNumber));
        order_contents.setAdapter(adapter);
    }
}
