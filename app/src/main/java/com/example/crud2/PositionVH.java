package com.example.crud2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PositionVH extends RecyclerView.ViewHolder
{
    public TextView txt_name1,txt_name21,txt_name213;
    public PositionVH(@NonNull View itemView) {
        super(itemView);
        txt_name1 = itemView.findViewById(R.id.txt_name);
        txt_name21 = itemView.findViewById(R.id.txt_name2);
        txt_name213 = itemView.findViewById(R.id.txt_name3);
    }
}
