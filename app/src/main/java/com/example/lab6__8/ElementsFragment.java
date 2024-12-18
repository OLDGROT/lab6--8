package com.example.lab6__8;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElementsFragment extends Fragment implements OnElementClickListener {
    private ElementBank elementBank = ElementBank.getInstance();
    private List<Element> elements;
    private ElementAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elements, container, false);

        elements = elementBank.getElements();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ElementAdapter(elements, this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onElementClick(int index) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("index", index);

        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        elements.clear();
        elements.addAll(ElementBank.getInstance().getElements());

        adapter.notifyDataSetChanged();
    }

}