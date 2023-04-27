package com.example.rutgerscafe;

import static com.example.rutgerscafe.StoreOrderController.StoreOrderList;
import static com.example.rutgerscafe.StoreOrderController.total_amount;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * controls basket view activity
 * @author Zhenglin Li, Adrian Mosquera
 */
public class basketController extends AppCompatActivity {

    public static double subtotal = 0;
    public double total = 0;
    public double salesTax = 0;
    DecimalFormat moneyFormat = new DecimalFormat("#.##");

    EditText subtotalTextBox, totalTextBox, taxTextbox;
    Button placeOrder;


    private double costRemoved = 0;

    private static double TAX_AMOUNT = 0.07;
    private ArrayAdapter<String> adapter;


    public static ArrayList<String> order = new ArrayList<>();

    /**
     * Stuff done on new instance of activity.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        subtotalTextBox = (EditText) findViewById(R.id.subTotalOrderTextBox);
        taxTextbox = (EditText) findViewById(R.id.salesTaxOrderTextBox);
        totalTextBox = (EditText) findViewById(R.id.totalOrderTextBox);

        ListView orderList = (ListView) findViewById(R.id.orderViewListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order);

        placeOrder = (Button) findViewById(R.id.placeOrderButton);

        subtotalTextBox.setText("$" + moneyFormat.format(subtotal) + "");

        salesTax = subtotal * TAX_AMOUNT;
        total = subtotal + salesTax;

        totalTextBox.setText("$" + moneyFormat.format(total) + "");
        taxTextbox.setText("$" + moneyFormat.format(salesTax) + "");


        orderList.setAdapter(adapter);


        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Pops up alert dialog giving the
             * option to delete an item or not.
             * @param parent The AdapterView where the click happened.
             * @param view The view within the AdapterView that was clicked (this
             *            will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(basketController.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + position);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    /**
                     * Deletes item from list view, and subtracts cost from total.
                     * Adjusts total and tax sales.
                     * @param dialog the dialog that received the click
                     * @param which the button that was clicked (ex.
                     *              {@link DialogInterface#BUTTON_POSITIVE}) or the position
                     *              of the item clicked
                     */
                    public void onClick(DialogInterface dialog, int which) {
                        String removedItem = order.get(positionToRemove);
                        order.remove(positionToRemove);

                        String cleanedItem = removedItem.replaceAll("\\D+", "");
                        costRemoved = (Double.parseDouble(cleanedItem)) * .01;


                        subtotal = subtotal - costRemoved;
                        salesTax = subtotal * TAX_AMOUNT;
                        total = subtotal + salesTax;

                        subtotalTextBox.setText("$" + moneyFormat.format(subtotal) + "");
                        totalTextBox.setText("$" + moneyFormat.format(total) + "");
                        taxTextbox.setText("$" + moneyFormat.format(salesTax) + "");

                        adapter.notifyDataSetChanged();



                    }
                });
                adb.show();
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            /**
             * Pops alert when you press Order button.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(basketController.this);
                adb.setTitle("Order?");
                adb.setMessage("Are you sure you want to order?");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    /**
                     * resets everything in order listview and pushes data to temp array to store
                     * in store orders.
                     * @param dialog the dialog that received the click
                     * @param which the button that was clicked (ex.
                     *              {@link DialogInterface#BUTTON_POSITIVE}) or the position
                     *              of the item clicked
                     */
                    public void onClick(DialogInterface dialog, int which) {
                        ArrayList<String>temp = new ArrayList<>();
                        for(int i=0;i<order.size();i++){
                            temp.add(order.get(i));
                        }
                        StoreOrderList.add(temp);
                        total_amount.add(total);
                        subtotal = 0;
                        salesTax = 0;
                        total = 0;

                        subtotalTextBox.setText("$" + moneyFormat.format(subtotal) + "");
                        totalTextBox.setText("$" + moneyFormat.format(total) + "");
                        taxTextbox.setText("$" + moneyFormat.format(salesTax) + "");
                        order.clear();
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Order has been added to the store.", Toast.LENGTH_LONG).show();
                    }
                });
                adb.show();
            }
        });
    }
}