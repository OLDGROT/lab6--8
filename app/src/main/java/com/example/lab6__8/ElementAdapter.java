package com.example.lab6__8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder> {
    private List<Element> elements;

    public ElementAdapter(List<Element> elements) {
        this.elements = elements;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        Element element = elements.get(position);
        holder.titleTextView.setText(element.getTitle());
        holder.detailsTextView.setText(element.getDetails());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, detailsTextView;

        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(android.R.id.text1);
            detailsTextView = itemView.findViewById(android.R.id.text2);
        }
    }
}

