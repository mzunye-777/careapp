package com.jfree.wecareapp.docset;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.jfree.wecareapp.R;

        import java.util.ArrayList;
        import java.util.List;

public class convoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    private PatientAdapter patientAdapter;
    private List<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo);

        recyclerViewPatients = findViewById(R.id.recyclerViewPatients);
        recyclerViewPatients.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for patients (replace this with your actual data)
        patients = new ArrayList<>();
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
            holder.patientNameTextView.setText(patient.getName());
            holder.patientDescriptionTextView.setText(patient.getDescription());
            holder.patientImageView.setImageResource(patient.getImageResId());

            // Set click listener to handle patient click event
            holder.itemView.setOnClickListener(v -> {
                // Handle patient click event here
                // You can view patient details and schedule a video call with Zoom
                String zoomLink = patient.getZoomLink();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(zoomLink));
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return patients.size();
        }

        public class PatientViewHolder extends RecyclerView.ViewHolder {
            TextView patientNameTextView;
            TextView patientDescriptionTextView;
            ImageView patientImageView;

            public PatientViewHolder(@NonNull View itemView) {
                super(itemView);
                patientNameTextView = itemView.findViewById(R.id.textViewPatientName);
                patientDescriptionTextView = itemView.findViewById(R.id.textViewPatientDescription);
                //patientDescriptionTextView = itemView.findViewById(R.id.patientDescriptionTextView);
                patientImageView = itemView.findViewById(R.id.imageViewPatient);
            }
        }
    }
}


