package com.kassandra.apps.flutter.course;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudentsGridRVAdapter extends RecyclerView.Adapter<StudentsGridRVAdapter.ItemsViewHolder> {

    ArrayList<String> studentNamesArrayList;
    ArrayList<String> studentImagesArrayList;
    ArrayList<Integer> studentRollNoArrayList;
    Context context;

    public StudentsGridRVAdapter(ArrayList<String> studentNamesArrayList, ArrayList<String> studentImagesArrayList,
                                 ArrayList<Integer> studentRollNoArrayList, Context context) {
        this.studentNamesArrayList = studentNamesArrayList;
        this.studentImagesArrayList = studentImagesArrayList;
        this.studentRollNoArrayList = studentRollNoArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.gv_students_item, parent, false);
        ItemsViewHolder itemsViewHolder = new ItemsViewHolder(view);
        return itemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.tvName.setText(studentNamesArrayList.get(position));
        holder.tvRollNo.setText(String.valueOf(studentRollNoArrayList.get(position)));
        Glide.with(context).load(studentImagesArrayList.get(position)).into(holder.ivLogo);

        holder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Delete?");
                alertDialog.setMessage("Do you want to delete this student?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int clickedPosition = holder.getAdapterPosition();
                        studentNamesArrayList.remove(clickedPosition);
                        studentImagesArrayList.remove(clickedPosition);
                        studentRollNoArrayList.remove(clickedPosition);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentNamesArrayList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvRollNo;
        ImageView ivLogo, ivRemove;
        View root;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView;
            tvName = itemView.findViewById(R.id.tvName);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            ivRemove = itemView.findViewById(R.id.ivRemove);
            tvRollNo = itemView.findViewById(R.id.tvRollNo);
        }
    }
}
