package com.example.jobhunting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ApplyJobViewAdapter extends RecyclerView.Adapter<ApplyJobViewAdapter.ViewHolder> {

    private List<AppliedJobs> jobsList;
    private Context context;

    public ApplyJobViewAdapter(List<AppliedJobs> jobsList, Context context) {
        this.jobsList = jobsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ApplyJobViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jobs, parent, false);
        return new ApplyJobViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplyJobViewAdapter.ViewHolder holder, int position) {
        final int itemPosition = position;
        final AppliedJobs job = jobsList.get(itemPosition);
        holder.title.setText(job.getTitle());
        holder.company.setText(job.getCompany());
        holder.salary.setText(job.getSalary());
        holder.description.setText(job.getDescription());
        holder.edit.setText("APPLIED");
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
}
