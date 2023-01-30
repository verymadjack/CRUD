package com.example.crud2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ComputerVH extends RecyclerView.ViewHolder
{
    public TextView txt_name31,txt_name32,txt_name33,txt_option3;
    public ComputerVH(@NonNull View itemView) {
        super(itemView);
        txt_name31 = itemView.findViewById(R.id.txt_name);
        txt_name32 = itemView.findViewById(R.id.txt_name2);
        txt_name33 = itemView.findViewById(R.id.txt_name3);
        txt_option3 = itemView.findViewById(R.id.txt_option);
    }
}