package com.jfree.wecareapp.docset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jfree.wecareapp.Database;
import com.jfree.wecareapp.DocActivity;
import com.jfree.wecareapp.HomeActivity;
import com.jfree.wecareapp.LoginActivity;
import com.jfree.wecareapp.R;
import com.jfree.wecareapp.Register;

public class docloginactivity extends AppCompatActivity {

    EditText dedUsername, dedPassword;
    Button btn;
    TextView tv, DA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docloginactivity);


        dedUsername = findViewById(R.id.editTextLoginUsername);
        dedPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);
        DA = findViewById(R.id.textViewNewDoc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(docloginactivity.this,dochome.class));
                String username = dedUsername.getText().toString();
                String password = dedPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }else{
                    if(db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        //to save our data with key and value
                        editor.apply();
                        startActivity(new Intent(docloginactivity.this, HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
