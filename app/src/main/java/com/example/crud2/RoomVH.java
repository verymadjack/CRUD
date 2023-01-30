package com.example.crud2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoomVH extends RecyclerView.ViewHolder
{
    public TextView txt_name41,txt_name42,txt_name43,txt_option4;
    public RoomVH(@NonNull View itemView) {
        super(itemView);
        txt_name41 = itemView.findViewById(R.id.txt_name);
        txt_name42 = itemView.findViewById(R.id.txt_name2);
        txt_name43 = itemView.findViewById(R.id.txt_name3);
        txt_option4 = itemView.findViewById(R.id.txt_option);
    }
}