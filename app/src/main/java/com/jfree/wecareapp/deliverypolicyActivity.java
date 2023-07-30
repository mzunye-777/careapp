package com.jfree.wecareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jfree.wecareapp.docset.docloginactivity;

public class deliverypolicyActivity extends AppCompatActivity {

    Button payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverypolicy);


        payment = findViewById(R.id.buttonpayment);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(deliverypolicyActivity.this, HomeActivity.class));
                Toast.makeText(getApplicationContext(),"Your order has been successfully placed",Toast.LENGTH_LONG).show();
            }
        });
    }
}