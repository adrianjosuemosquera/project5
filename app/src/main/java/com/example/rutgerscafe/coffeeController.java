package com.example.rutgerscafe;

import static com.example.rutgerscafe.basketController.order;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class coffeeController extends AppCompatActivity {

    String Mocha = "Mocha";
    String SweetCream = "Sweet Cream";
    String FrenchVanilla = "French Vanilla";
    String Caramel = "Caramel";
    String IrishCream = "Irish Cream";


    DecimalFormat moneyFormat = new DecimalFormat("#.##");
    CheckBox sweetCream, irishCream, caramel, mocha, frenchVanilla;
    RadioButton tall, venti, grande;

    Button addToOrder;
    EditText price;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_view);

        price = (EditText) findViewById(R.id.subtotalTextBox);

        irishCream = (CheckBox) findViewById(R.id.irishCreamCheckBox);
        sweetCream = (CheckBox) findViewById(R.id.sweetCreamBox);
        caramel = (CheckBox) findViewById(R.id.caramelCheckBox);
        mocha = (CheckBox) findViewById(R.id.mochaCheckBox);
        frenchVanilla = (CheckBox) findViewById(R.id.frenchVanillaCheckBox);

        tall = (RadioButton) findViewById(R.id.smallButton);
        venti = (RadioButton) findViewById(R.id.largeButton);
        grande = (RadioButton) findViewById(R.id.mediumButton);

        addToOrder = (Button) findViewById(R.id.addToOrderButton);

        irishCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * @param buttonView The compound button view whose state has changed.
             * @param isChecked  The new checked state of buttonView.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    mocha.setChecked(false);
                    frenchVanilla.setChecked(false);
                    caramel.setChecked(false);
                    sweetCream.setChecked(false);

                    coffee.addIns = IrishCream;


                    coffee.price += .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
                if(!isChecked) {
                    coffee.price -= .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
            }
        });

        frenchVanilla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * @param buttonView The compound button view whose state has changed.
             * @param isChecked  The new checked state of buttonView.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    mocha.setChecked(false);
                    caramel.setChecked(false);
                    sweetCream.setChecked(false);
                    irishCream.setChecked(false);

                    coffee.addIns = FrenchVanilla;


                    coffee.price += .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
                if(!isChecked) {
                    coffee.price -= .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
            }
        });

        caramel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * @param buttonView The compound button view whose state has changed.
             * @param isChecked  The new checked state of buttonView.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    mocha.setChecked(false);
                    frenchVanilla.setChecked(false);
                    sweetCream.setChecked(false);
                    irishCream.setChecked(false);

                    coffee.addIns = Caramel;


                    coffee.price += .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
                if(!isChecked) {
                    coffee.price -= .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
            }
        });

        sweetCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * @param buttonView The compound button view whose state has changed.
             * @param isChecked  The new checked state of buttonView.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    mocha.setChecked(false);
                    frenchVanilla.setChecked(false);
                    caramel.setChecked(false);
                    irishCream.setChecked(false);

                    coffee.addIns = SweetCream;


                    coffee.price += .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
                if(!isChecked) {
                    coffee.price -= .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
            }
        });

        mocha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * @param buttonView The compound button view whose state has changed.
             * @param isChecked  The new checked state of buttonView.
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    frenchVanilla.setChecked(false);
                    caramel.setChecked(false);
                    sweetCream.setChecked(false);
                    irishCream.setChecked(false);

                    coffee.addIns = Mocha;

                    coffee.price += .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
                if(!isChecked) {


                    coffee.price -= .30;
                    price.setText(moneyFormat.format(coffee.price) + "");
                }
            }
        });

        tall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    coffee.cupSize = "Tall";

                    mocha.setChecked(false);
                    frenchVanilla.setChecked(false);
                    caramel.setChecked(false);
                    sweetCream.setChecked(false);
                    irishCream.setChecked(false);


                    mocha.setClickable(true);
                    frenchVanilla.setClickable(true);
                    caramel.setClickable(true);
                    sweetCream.setClickable(true);
                    irishCream.setClickable(true);

                    coffee.price = 1.89;
                    price.setText(coffee.price + "");
                }
            }
        });
        grande.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(isChecked) {

                        coffee.cupSize = "Grande";

                        mocha.setChecked(false);
                        frenchVanilla.setChecked(false);
                        caramel.setChecked(false);
                        sweetCream.setChecked(false);
                        irishCream.setChecked(false);

                        mocha.setClickable(true);
                        frenchVanilla.setClickable(true);
                        caramel.setClickable(true);
                        sweetCream.setClickable(true);
                        irishCream.setClickable(true);

                        coffee.price = 2.29;
                        price.setText(coffee.price + "");
                    }
                }
            }
        });
        venti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    coffee.cupSize = "Venti";

                    mocha.setChecked(false);
                    frenchVanilla.setChecked(false);
                    caramel.setChecked(false);
                    sweetCream.setChecked(false);
                    irishCream.setChecked(false);

                    mocha.setClickable(true);
                    frenchVanilla.setClickable(true);
                    caramel.setClickable(true);
                    sweetCream.setClickable(true);
                    irishCream.setClickable(true);

                    coffee.price = 2.89;
                    price.setText(coffee.price + "");
                }
            }
        });

        addToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.add(coffee.cupSize + " " + coffee.addIns + " Coffee" + "   " + coffee.price);
            }
        });

    }

}
