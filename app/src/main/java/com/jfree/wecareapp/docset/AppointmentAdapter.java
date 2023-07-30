package com.jfree.wecareapp.docset;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jfree.wecareapp.R;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    private List<Appointment> appointments;

    public AppointmentAdapter(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.appointmentDateTextView.setText("Date: " + appointment.getDate());
        holder.appointmentTimeTextView.setText("Time: " + appointment.getTime());
        holder.patientNameTextView.setText("Patient Name: " + appointment.getPatientName());
        holder.diseaseTextView.setText("Disease: " + appointment.getDisease());
        holder.testsTextView.setText("Tests: " + appointment.getTests());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
        notifyDataSetChanged();
    }

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView appointmentDateTextView;
        TextView appointmentTimeTextView;
        TextView patientNameTextView;
        TextView diseaseTextView;
        TextView testsTextView;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            appointmentDateTextView = itemView.findViewById(R.id.appointmentDateTextView);
            appointmentTimeTextView = itemView.findViewById(R.id.appointmentTimeTextView);
            patientNameTextView = itemView.findViewById(R.id.patientNameTextView);
            diseaseTextView = itemView.findViewById(R.id.diseaseTextView);
            testsTextView = itemView.findViewById(R.id.testsTextView);
        }
    }
}
