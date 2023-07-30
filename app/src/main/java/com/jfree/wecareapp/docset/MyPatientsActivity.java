package com.jfree.wecareapp.docset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jfree.wecareapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyPatientsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    private PatientAdapter patientAdapter;
    private List<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_patients);

        recyclerViewPatients = findViewById(R.id.recyclerViewPatients);
        recyclerViewPatients.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for patients (replace this with your actual data)
        patients = new ArrayList<>();

        // Here, we only pass name, description, imageResId, and zoomLink to the Patient constructor
        patients.add(new Patient("John Doe", "Patient with fever", R.drawable.patient1, "https://zoom.us/"));
        patients.add(new Patient("Jane Smith", "Patient with headache", R.drawable.patient1, "https://zoom.us/"));
        patients.add(new Patient("Michael Johnson", "Patient with cough", R.drawable.patient1, "https://zoom.us/"));
        patients.add(new Patient("Emily Williams", "Patient with sore throat", R.drawable.patient1, "https://zoom.us/"));
        // Add more patients as needed

        patientAdapter = new PatientAdapter(patients);
        recyclerViewPatients.setAdapter(patientAdapter);
    }

    private class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

        private List<Patient> patients;

        public PatientAdapter(List<Patient> patients) {
            this.patients = patients;
        }

        @NonNull
        @Override
        public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);
            return new PatientViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
            Patient patient = patients.get(position);
            //holder.patientNameTextView.setText(patient.getName());
            //holder.patientDescriptionTextView.setText(patient.getDescription());
            holder.patientImageView.setImageResource(patient.getImageResId());

            // Set additional patient details (medication status and cured status)
            // Here, you can set the medication status and cured status as needed
            String medicationStatus = "On Medication"; // Replace with actual logic for medication status
            String curedStatus = "Not Cured"; // Replace with actual logic for cured status

            holder.medicationStatusTextView.setText(medicationStatus);
            holder.curedStatusTextView.setText(curedStatus);
        }

        @Override
        public int getItemCount() {
            return patients.size();
        }

        public class PatientViewHolder extends RecyclerView.ViewHolder {
            TextView patientNameTextView;
            TextView patientDescriptionTextView;
            ImageView patientImageView;
            TextView medicationStatusTextView;
            TextView curedStatusTextView;

            public PatientViewHolder(@NonNull View itemView) {
                super(itemView);
                patientNameTextView = itemView.findViewById(R.id.patientNameTextView);
                //patientDescriptionTextView = itemView.findViewById(R.id.patientDescriptionTextView);
                patientImageView = itemView.findViewById(R.id.imageViewPatient);
                medicationStatusTextView = itemView.findViewById(R.id.medicationStatusTextView);
                curedStatusTextView = itemView.findViewById(R.id.curedStatusTextView);
            }
        }
    }
}
