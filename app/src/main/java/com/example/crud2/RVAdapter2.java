package com.example.crud2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Position> list = new ArrayList<>();
    public RVAdapter2(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Position> pos)
    {
        list.addAll(pos);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);

        return new PositionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PositionVH vh = (PositionVH) holder;
        Position pos = list.get(position);
        vh.txt_name1.setText(pos.getPosName());
        vh.txt_name21.setText(pos.getSalary());
        vh.txt_name213.setText(pos.getSalary());

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
