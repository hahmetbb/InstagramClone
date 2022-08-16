package com.hahmetbuyukbesnili.instaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hahmetbuyukbesnili.instaclone.databinding.RecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    private ArrayList<Post> postArrayList;

    public FeedAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FeedHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        holder.binding.recyclerViewEmailText.setText(postArrayList.get(position).email);
        holder.binding.recyclerViewCommentText.setText(postArrayList.get(position).comment);
        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.binding.recyclerViewImageView);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder{
        RecyclerRowBinding binding;
        public FeedHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
