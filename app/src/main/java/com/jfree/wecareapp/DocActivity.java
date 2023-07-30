package com.jfree.wecareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.jfree.wecareapp.docset.docloginactivity;

public class DocActivity extends AppCompatActivity {

    Button dbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        dbtn = findViewById(R.id.buttondocLogin);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this, docloginactivity.class));
            }
        });
    }
}