package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class openElementTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_element_two);

        final DatabaseReference[] databaseReference = new DatabaseReference[1];
        EditText editTextOne = findViewById(R.id.elementEdit21);
        EditText editTextTwo = findViewById(R.id.elementEdit22);
        EditText editTextThree = findViewById(R.id.elementEdit23);
        Button buttonUpload = findViewById(R.id.elementButton);
        DAOPosition daoTwo = new DAOPosition();
        Position pos_edit = (Position)getIntent().getSerializableExtra("EDIT");
        if(pos_edit != null)
        {
            buttonUpload.setText("UPDATE");
            editTextOne.setText(pos_edit.getPosName());
            editTextTwo.setText(pos_edit.getSalary());
            editTextThree.setText(pos_edit.getHours());

        }
        else{
            buttonUpload.setText("SUBMIT");

        }

        buttonUpload.setOnClickListener(v->{
            Position pos = new Position(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            if(pos_edit==null) {
                daoTwo.add(pos).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
            {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", editTextOne.getText().toString());
                hashMap.put("position", editTextTwo.getText().toString());
                hashMap.put("age", editTextThree.getText().toString());
                daoTwo.update(pos_edit.getKey(), hashMap).addOnSuccessListener(suc->{
                    Toast.makeText(this,"record is updated", Toast.LENGTH_SHORT).show();
                    finish();

                }).addOnFailureListener(er->{
                    Toast.makeText(this, ""+ er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");



    }
}