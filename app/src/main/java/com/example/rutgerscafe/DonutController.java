package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.*;
import android.view.View;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class DonutController extends AppCompatActivity {
    private String type, flavor, quantity;
    private Spinner donut_type, donut_flavor, donut_quantity;
    private TextView donut_subtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);
        addItems();
    }
    public void addItems(){
        donut_type = findViewById(R.id.donut_type);
        donut_flavor = findViewById(R.id.donut_flavor);
        donut_quantity = findViewById(R.id.donut_quantity);
        ArrayAdapter<String> adapter_type = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter_flavor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter_quantity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);

        adapter_type.addAll("Yeast Donut ($1.59)","Cake Donut($1.79)", "Donut Holes($0.39)");
        adapter_flavor.addAll("Plain", "Chocolate", "White Chocolate", "Strawberry", "Glazed", "Boston Cream");
        adapter_quantity.addAll("One","Two", "Four", "Half Dozen", "Eight", "Dozen");

        donut_type.setAdapter(adapter_type);
        donut_flavor.setAdapter(adapter_flavor);
        donut_quantity.setAdapter(adapter_quantity);
    }
    private void getValues(){
        donut_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
        donut_flavor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                flavor = adapterView.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
        donut_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantity = adapterView.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
    }
    private double getPrice(){
        double price = 0.0;
        if(flavor.compareTo(" ")!=0 && type.compareTo(" ")!=0 && quantity.compareTo(" ")!=0){
            int quant = getDonutQuant();
            if(type.compareTo("Yeast Donut ($1.59)")==0){
                price = 1.59*quant;
            }else if(type.compareTo("Cake Donut($1.79)")==0){
                price = 1.79*quant;
            }else if(type.compareTo("Donut Holes($0.39)")==0){
                price = 0.39*quant;
            }
        }

        return price;
    }

    private int getDonutQuant(){
        String quant = quantity;
        int num = 0;
        if(quant==null){
            return num;
        }
        if(quant.contains("One")){
            num = 1;
        }else if(quant.contains("Two")){
            num = 2;
        }else if(quant.contains("Four")){
            num = 4;
        }else if(quant.contains("Half")){
            num = 6;
        }else if(quant.contains("Eight")){
            num = 8;
        }else if(quant.contains("Dozen")){
            num = 12;
        }
        return num;
    }

    public void setDonutSubtotal(View view){
        addItems();
        getValues();
        if(type==null){
            alert("Type not selected", "Please select the type of donut to order");
            return;}
        if(type.compareTo(" ")==0){
            alert("Type not selected", "Please select the type of donut to order");
            return;
        }
        if(flavor==null){
            alert("Flavor not selected", "Please select the flavor for the donut");
            return;
        }
        if(flavor.compareTo(" ")==0||flavor==null){
            alert("Flavor not selected", "Please select the flavor for the donut");
            return;
        }
        if(quantity==null){
            alert("Quantity not selected", "Please select the numbers of donuts you want to order");
            return;}
        if(quantity.compareTo(" ")==0||quantity==null){
            alert("Quantity not selected", "Please select the numbers of donuts you want to order");
            return;
        }
        donut_subtotal=findViewById(R.id.donut_price);
        donut_subtotal.setText(Double.toString(getPrice()));
        Toast.makeText(this, "Order Added", Toast.LENGTH_LONG).show();
    }

    private void alert(String title, String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title)
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert);
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

}
