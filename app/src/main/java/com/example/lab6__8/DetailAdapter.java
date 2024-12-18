package com.example.lab6__8;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private ElementBank elementBank = ElementBank.getInstance();
    private Element element;
    private int index;

    public DetailAdapter(Element element, int index){
        this.element = element;
        this.index = index;
    }

    @NonNull
    @Override
    public DetailAdapter.DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail, parent, false);
        return new DetailAdapter.DetailViewHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {

        if (element instanceof Group) {
            Group groupElement = (Group) element;
            holder.titleTextView.setText("Группа:");
            holder.titleEditText.setText(groupElement.getName());
            holder.detailTextView.setText("Кафедра:");
            holder.detailsEditText.setText(groupElement.getDepartment());
            holder.descriptionTextView.setText("Описание:");
            holder.descriptionEditText.setText(groupElement.getDescription());
            element = groupElement;
        }else{
            MaterialForLecction lecctionElement = (MaterialForLecction) element;
            holder.titleTextView.setText("Тема:");
            holder.titleEditText.setText(lecctionElement.getTema());
            holder.detailTextView.setText("Аудитория:");
            holder.detailsEditText.setText(lecctionElement.getCabinet());
            holder.descriptionTextView.setText("Описание:");
            holder.descriptionEditText.setText(lecctionElement.getDescription());
            element = lecctionElement;
        }

        holder.titleEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                element.setTitle(holder.titleEditText.getText().toString());
                elementBank.setElement(element, index);
            }
        });

        holder.detailsEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                element.setDetails(holder.detailsEditText.getText().toString());
                elementBank.setElement(element, index);
            }
        });

        holder.descriptionEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                element.setDescription(holder.descriptionEditText.getText().toString());
                elementBank.setElement(element, index);
            }
        });

    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, detailTextView, descriptionTextView;
        EditText titleEditText, detailsEditText, descriptionEditText;
        View rootLayout;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textview1);
            detailTextView = itemView.findViewById(R.id.textview2);
            descriptionTextView = itemView.findViewById(R.id.textview3);

            titleEditText = itemView.findViewById(R.id.titleEditText);
            detailsEditText = itemView.findViewById(R.id.detailsEditText);
            descriptionEditText = itemView.findViewById(R.id.descriptionEditText);
            
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
