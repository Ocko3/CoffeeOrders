package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int price = 10;
    String workerName = "Oli";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "That would be " + NumberFormat.getCurrencyInstance().format(quantity * price);
        String servedBy = "Served by " + workerName + " with love.";
        displayMessage(priceMessage, servedBy);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        quantity++;
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void decrement(View view){
        quantity--;
        if(quantity <= 0){
            quantity = 1;
        }
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message, String servedBy) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
        TextView servedByTextView = (TextView) findViewById(R.id.served_by_text_view);
        servedByTextView.setText(servedBy);
    }
}