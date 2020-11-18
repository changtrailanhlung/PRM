package com.example.jobhunting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobsRecyclerViewAdapter extends RecyclerView.Adapter<JobsRecyclerViewAdapter.ViewHolder> {

    private List<Jobs> jobsList;
    private Context context;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;


    public JobsRecyclerViewAdapter(List<Jobs> jobsList, Context context, FirebaseFirestore firebaseFirestore, FirebaseAuth mAuth) {
        this.jobsList = jobsList;
        this.context = context;
        this.firebaseFirestore = firebaseFirestore;
        this.mAuth = mAuth;
    }

    @NonNull
    @Override
    public JobsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jobs, parent, false);
        return new JobsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsRecyclerViewAdapter.ViewHolder holder, int position) {
        final int itemPosition = position;
        final Jobs job = jobsList.get(itemPosition);
        holder.title.setText(job.getTitle());
        holder.company.setText(job.getCompany());
        holder.salary.setText(job.getSalary());
        holder.description.setText(job.getDescription());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteJobsApplied(mAuth.getUid(), "Approved", mAuth.getCurrentUser().getEmail(), job.getCompany(), job.getTitle(), itemPosition);
                Toast.makeText(context, "Job Applied !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, company, salary, description, edit;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tvTitle);
            company = view.findViewById(R.id.Company);
            salary = view.findViewById(R.id.Salary);
            description = view.findViewById(R.id.Description);
            edit = view.findViewById(R.id.applyJobs);
        }
    }

    private void deleteJobsApplied(String id, String approval, String email, String company, String job, int position) {
        Map<String, Object> job_apply = new HashMap<>();
        job_apply.put("approval", approval);
        job_apply.put("email", email);
        job_apply.put("company", company);
        job_apply.put("title", job);
        firebaseFirestore.collection("job_apply").document(id).set(job_apply).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                jobsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, jobsList.size());
            }
        });
    }
}
