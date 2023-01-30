package com.example.crud2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Computer> list = new ArrayList<>();

    public RVAdapter3(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<Computer> com) {
        list.addAll(com);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);

        return new ComputerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ComputerVH vh = (ComputerVH) holder;
        Computer com = list.get(position);
        vh.txt_name31.setText(com.getComName());
        vh.txt_name32.setText(com.getYear());
        vh.txt_name33.setText(com.getNeedsFixing());
        vh.txt_option3.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option3);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context, openElementThree.class);
                        intent.putExtra("EDIT", com);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_delete:
                        DAOComputer daoComputer = new DAOComputer();
                        daoComputer.remove(com.getKey()).addOnSuccessListener(suc -> {
                            Toast.makeText(context, "record is deleted", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);

                        }).addOnFailureListener(er -> {
                            Toast.makeText(context, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                        break;
                }
                return false;
            });
            popupMenu.show();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
