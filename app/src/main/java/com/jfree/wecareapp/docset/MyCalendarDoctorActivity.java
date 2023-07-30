package com.jfree.wecareapp.docset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.jfree.wecareapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyCalendarDoctorActivity extends AppCompatActivity {

    private CompactCalendarView calendarView;
    private RecyclerView recyclerView;
    private AppointmentAdapter appointmentAdapter;
    private List<Appointment> appointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar_doctor);

        calendarView = findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recycle_time_slot2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for appointments (replace this with your actual data)
        appointments = new ArrayList<>();
        appointments.add(new Appointment("2023-04-01", "10:00 AM", "John Doe", "Fever", "Blood Test"));
        appointments.add(new Appointment("2023-04-02", "11:30 AM", "Jane Smith", "Headache", "MRI"));
        appointments.add(new Appointment("2023-04-03", "2:45 PM", "Michael Johnson", "Cough", "X-ray"));
        appointments.add(new Appointment("2023-04-04", "4:15 PM", "Emily Williams", "Sore Throat", "Throat Swab"));

        // Set the adapter for the RecyclerView
        appointmentAdapter = new AppointmentAdapter(appointments);
        recyclerView.setAdapter(appointmentAdapter);

        // Set a listener to handle calendar date clicks
        calendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // Handle date click event here
                // You can filter the appointments based on the selected date and update the RecyclerView accordingly
                List<Appointment> filteredAppointments = getFilteredAppointmentsForDate(dateClicked);
                appointmentAdapter.setAppointments(filteredAppointments);
                appointmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                // Handle month scroll event here
                // You can update the RecyclerView based on the newly visible month's appointments

                // Clear previous events from CompactCalendarView
                calendarView.removeAllEvents();

                // Populate the calendar with appointments for the new month
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (Appointment appointment : appointments) {
                    try {
                        Date date = sdf.parse(appointment.getDate());
                        if (date.getMonth() == firstDayOfNewMonth.getMonth()) {
                            int color = Color.RED; // Set your desired color here
                            Event event = new Event(color, date.getTime());
                            calendarView.addEvent(event);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                // Refresh the RecyclerView with new month's appointments
                List<Appointment> filteredAppointments = getFilteredAppointmentsForDate(firstDayOfNewMonth);
                appointmentAdapter.setAppointments(filteredAppointments);
                appointmentAdapter.notifyDataSetChanged();
            }
        });

        // Populate the initial calendar with appointments
        for (Appointment appointment : appointments) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(appointment.getDate());
                int color = Color.RED; // Set your desired color here
                Event event = new Event(color, date.getTime());
                calendarView.addEvent(event);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method to filter appointments for the selected date
    private List<Appointment> getFilteredAppointmentsForDate(Date date) {
        List<Appointment> filteredAppointments = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDateStr = sdf.format(date);

        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(selectedDateStr)) {
                filteredAppointments.add(appointment);
            }
        }
        return filteredAppointments;
    }
}
