package com.example.crud2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_name2,txt_name3;
    public EmployeeVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_name2 = itemView.findViewById(R.id.txt_name2);
        txt_name3 = itemView.findViewById(R.id.txt_name3);
    }
}