package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {

    TextView orderSummaryText;
    Button paymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderSummaryText = findViewById(R.id.orderSummaryText);
        paymentButton = findViewById(R.id.paymentButton);

        List<FoodItem> cartItems = (List<FoodItem>) getIntent().getSerializableExtra("cartItems");
        String orderType = getIntent().getStringExtra("orderType");

        StringBuilder summary = new StringBuilder();
        summary.append("Order Type: ").append(orderType).append("\n\n");

        double total = 0;
        for (FoodItem item : cartItems) {
            summary.append(item.getName()).append(" - ₹").append(item.getCost())
                    .append(" x ").append(item.getQuantity()).append("\n");
            total += Integer.parseInt(item.getCost()) * item.getQuantity();
        }

        summary.append("\nTotal Cost: ₹").append(total);

        orderSummaryText.setText(summary.toString());
        // Set the Payment Button Listener
        double finalTotal = total; // Use a final variable for access inside the listener
        paymentButton.setOnClickListener(v -> {
            Intent intent = new Intent(Order.this, Payment.class);
            intent.putExtra("cartItems", new ArrayList<>(cartItems)); // Pass cartItems
            intent.putExtra("orderType", orderType); // Pass orderType
            intent.putExtra("totalCost", finalTotal); // Pass total cost
            startActivity(intent);
   });
}



}