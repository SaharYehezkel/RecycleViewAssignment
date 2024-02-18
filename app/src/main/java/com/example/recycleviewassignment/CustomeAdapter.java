package com.example.recycleviewassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private List<DataModel> dataset;
    private List<DataModel> originalDataset;
    private View.OnClickListener itemClickListener;

    public CustomeAdapter(List<DataModel> dataSet) {
        this.dataset = dataSet;
        this.originalDataset = new ArrayList<>(dataSet); // Create a copy of the original dataset
        this.itemClickListener = itemClickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView);
            textViewDescription = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(itemClickListener); // Set click listener to the view
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewDescription;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewVersion.setText(dataset.get(position).getDescription());
        imageView.setImageResource(dataset.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailActivity.class);

                // Get the current DataModel item
                DataModel currentItem = dataset.get(position);

                // Pass the data
                intent.putExtra("name", currentItem.getName());
                intent.putExtra("imageDrawable", currentItem.getImage());
                intent.putExtra("bio", currentItem.getBio());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // Method to reset dataset to the original state
    public void resetDataset() {
        dataset = new ArrayList<>(originalDataset);
        notifyDataSetChanged();
    }

    public void filter(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();
        for (DataModel item : dataset) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        updateDataset(filteredList);
    }

    // Method to update dataset
    public void updateDataset(List<DataModel> filteredList) {
        dataset = filteredList;
        notifyDataSetChanged();
    }

}
