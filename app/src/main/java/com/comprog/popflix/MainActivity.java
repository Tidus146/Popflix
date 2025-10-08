package com.comprog.popflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = new ArrayList<>();
        movieList.add(new Movie("Interstellar", "A team of explorers travels through a wormhole in space to ensure humanity’s survival.", R.drawable.interstellar));
        movieList.add(new Movie("Inception", "A thief who steals secrets through dream-sharing technology is given a chance at redemption.", R.drawable.inception));
        movieList.add(new Movie("The Dark Knight", "Batman faces the Joker in a battle for Gotham’s soul.", R.drawable.dark_knight));

        adapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(adapter);
    }
}
