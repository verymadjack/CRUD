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

public class RVAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Position> list = new ArrayList<>();

    public RVAdapter2(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<Position> pos) {
        list.addAll(pos);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);

        return new PositionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PositionVH vh = (PositionVH) holder;
        Position pos = list.get(position);
        vh.txt_name1.setText(pos.getPosName());
        vh.txt_name21.setText(pos.getSalary());
        vh.txt_name213.setText(pos.getSalary());
        vh.txt_option2.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option2);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context, openElementTwo.class);
                        intent.putExtra("EDIT", pos);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_delete:
                        DAOPosition daoPosition = new DAOPosition();
                        daoPosition.remove(pos.getKey()).addOnSuccessListener(suc -> {
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
