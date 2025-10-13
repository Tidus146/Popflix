package com.example.popflix;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context ctx, List<Movie> movies) {
        this.context = ctx;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie m = movies.get(position);
        holder.title.setText(m.getTitle());
        holder.description.setText(m.getDescription());
        holder.image.setImageResource(m.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, MovieDetailActivity.class);
            i.putExtra("title", m.getTitle());
            i.putExtra("description", m.getDescription());
            i.putExtra("imageResId", m.getImageResId());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.textDescription);
        }
    }
}
