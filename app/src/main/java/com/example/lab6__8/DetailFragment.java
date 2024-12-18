package com.example.lab6__8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class DetailFragment extends Fragment {
    private ElementBank elementBank = ElementBank.getInstance();
    private Element element;
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_elements, container, false);

        if(savedInstanceState!=null){
            index = savedInstanceState.getInt("index",0);
        }

        element = elementBank.getElementById(index);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DetailAdapter adapter = new DetailAdapter(element, index);
        recyclerView.setAdapter(adapter);

        return view;


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
}