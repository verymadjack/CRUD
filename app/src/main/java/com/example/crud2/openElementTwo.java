package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        buttonUpload.setOnClickListener(v->{
            Position com = new Position(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            daoTwo.add(com).addOnSuccessListener(suc->{
                Toast.makeText(this,"Record inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
    }
}