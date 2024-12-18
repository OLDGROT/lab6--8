package com.example.lab6__8;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.UUID;

public class DetailsActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    int index;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragmentContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if(savedInstanceState != null){
            index = savedInstanceState.getInt("index", 0);
            Log.d("DetailsActivityLog","index=" + index);
        }else if(savedInstanceState == null) {
            Intent intent = getIntent();
            index = intent.getIntExtra("index", 0);
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) == null) {
            DetailFragment fragment = new DetailFragment();
            fragment.setIndex(index);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("index", index);
        Log.d("DetailsActivityLog","indexoutstet=" + index);
    }
}