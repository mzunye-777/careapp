package com.jfree.wecareapp.docset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.jfree.wecareapp.R;

import java.util.ArrayList;
import java.util.List;

public class AppointementActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppointmentAdapter appointmentAdapter;
    private List<Appointment> appointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for appointments (replace this with your actual data)
        appointments = new ArrayList<>();
        appointments.add(new Appointment("2023-04-01", "10:00 AM", "John Doe", "Fever", "Blood Test"));
        appointments.add(new Appointment("2023-04-02", "11:30 AM", "Jane Smith", "Headache", "MRI"));
        appointments.add(new Appointment("2023-04-03", "2:45 PM", "Michael Johnson", "Cough", "X-ray"));
        appointments.add(new Appointment("2023-04-04", "4:15 PM", "Emily Williams", "Sore Throat", "Throat Swab"));

        appointmentAdapter = new AppointmentAdapter(appointments);
        recyclerView.setAdapter(appointmentAdapter);
    }
}