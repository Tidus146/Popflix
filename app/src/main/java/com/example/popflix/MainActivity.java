package com.example.popflix;

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
        movieList.add(new Movie(
                "Interstellar",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                R.drawable.interstellar));
        movieList.add(new Movie(
                "Inception",
                "A thief who steals corporate secrets through dream-sharing technology is given the inverse task: plant an idea into the mind of a CEO.",
                R.drawable.inception));
        movieList.add(new Movie(
                "The Dark Knight",
                "Batman battles the Joker, a criminal mastermind who plunges Gotham into chaos.",
                R.drawable.dark_knight));

        adapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(adapter);
    }
}
