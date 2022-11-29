package com.kassandra.apps.flutter.course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsRVAdapter extends RecyclerView.Adapter<ItemsRVAdapter.ItemsViewHolder> {

    ArrayList<String> studentNamesArrayList;
    ArrayList<Integer> studentImagesArrayList;
    Context context;

    public ItemsRVAdapter(ArrayList<String> studentNamesArrayList, ArrayList<Integer> studentImagesArrayList,
                          Context context) {
        this.studentNamesArrayList = studentNamesArrayList;
        this.studentImagesArrayList = studentImagesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_lv_item, parent, false);
        ItemsViewHolder itemsViewHolder = new ItemsViewHolder(view);
        return itemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.tvTitle.setText(studentNamesArrayList.get(position));
        holder.ivLogo.setImageResource(studentImagesArrayList.get(position));
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position=" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentNamesArrayList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivLogo;
        View root;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}
