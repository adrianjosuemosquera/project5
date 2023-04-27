package com.example.rutgerscafe;

import static com.example.rutgerscafe.basketController.order;
import static com.example.rutgerscafe.basketController.subtotal;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.*;
import android.view.View;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.text.DecimalFormat;

/**
 * controls donut activity
 * @author Zhenglin Li, Adrian Mosquera
 */
public class DonutController extends AppCompatActivity {
    private static final double hole_price = 0.39, cake_price = 1.79, yeast_price = 1.59;
    private String type, flavor, quantity;
    private Spinner donut_type, donut_flavor, donut_quantity;
    private TextView donut_subtotal;

    /**
     * everything initialized at start of donut activity
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);
        addItems();
        getValues();
    }

    /**
     * adds items to array adapter
     */
    public void addItems(){
        donut_type = findViewById(R.id.donut_type);
        donut_flavor = findViewById(R.id.donut_flavor);
        donut_quantity = findViewById(R.id.donut_quantity);
        ArrayAdapter<String> adapter_type = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter_flavor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapter_quantity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);

        adapter_type.addAll(" ", "Yeast Donut($1.59)","Cake Donut($1.79)", "Donut Holes($0.39)");
        adapter_flavor.addAll(" ", "Plain", "Chocolate", "White Chocolate", "Strawberry", "Glazed", "Boston Cream");
        adapter_quantity.addAll(" ", "One","Two", "Four", "Half Dozen", "Eight", "Dozen");

        donut_type.setAdapter(adapter_type);
        donut_flavor.setAdapter(adapter_flavor);
        donut_quantity.setAdapter(adapter_quantity);
    }

    /**
     * gets values of selected items
     */
    private void getValues(){
        donut_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            /**
             * sets type of donut to item selected
             * @param adapterView The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param i The position of the view in the adapter
             * @param l The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getSelectedItem().toString();
            }

            /**
             * handles nothing selected exception
             * @param adapterView The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
        donut_flavor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            /**
             * sets flavor of donut to item selected
             * @param adapterView The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param i The position of the view in the adapter
             * @param l The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                flavor = adapterView.getSelectedItem().toString();
            }

            /**
             * handles nothing selected exception
             * @param adapterView The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
        donut_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            /**
             * sets quanity of donut to item selected
             * @param adapterView The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param i The position of the view in the adapter
             * @param l The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantity = adapterView.getSelectedItem().toString();
            }

            /**
             * handles nothing selected exception
             * @param adapterView The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){ }
        });
    }

    /**
     * adds price of donuts selected to subtotal
     * @return price of donuts
     */
    private double getPrice(){
        double price = 0.0;
        if(flavor.compareTo(" ")!=0 && type.compareTo(" ")!=0 && quantity.compareTo(" ")!=0){
            int quant = getDonutQuant();
            if(type.compareTo("Yeast Donut($1.59)")==0){
                price = yeast_price*quant;
                subtotal += price;
                type = "Yeast Donut";
            }else if(type.compareTo("Cake Donut($1.79)")==0){
                price = cake_price*quant;
                subtotal += price;
                type = "Cake Donut";
            }else if(type.compareTo("Donut Holes($0.39)")==0){
                price = hole_price*quant;
                subtotal += price;
                type = "Donut Holes";
            }
        }

        return price;
    }

    /**
     *
     * @return donut quantity
     */
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

    /**
     * sets donut subtotal text box
     * @param view
     */
    public void setDonutSubtotal(View view){
        addItems();
        getValues();
        if(type==null){
            alert("Type not selected", "Please select the type of donut to order");
            return;}
        if(type.compareTo(" ")==0){
            alert("Type not selected", "Please select the type of donut to order");
            return;}
        if(flavor==null){
            alert("Flavor not selected", "Please select the flavor for the donut");
            return;}
        if(flavor.compareTo(" ")==0||flavor==null){
            alert("Flavor not selected", "Please select the flavor for the donut");
            return;}
        if(quantity==null){
            alert("Quantity not selected", "Please select the numbers of donuts you want to order");
            return;}
        if(quantity.compareTo(" ")==0||quantity==null){
            alert("Quantity not selected", "Please select the numbers of donuts you want to order");
            return;}
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        donut_subtotal=findViewById(R.id.donut_price);
        String subtotal = decimalFormat.format(getPrice());
        donut_subtotal.setText(subtotal);
        Toast.makeText(this, quantity + " "+ flavor + " "+ type + " has been added to your order", Toast.LENGTH_LONG).show();
        order.add(quantity + " " + flavor + " " + type + " $" + subtotal);
    }

    /**
     * provides alert dialog for exception handling
     * @param title name of alert
     * @param msg what we need to communicate
     */
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
