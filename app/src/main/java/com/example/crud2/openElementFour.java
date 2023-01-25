package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class openElementFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_element_four);

        final DatabaseReference[] databaseReference = new DatabaseReference[1];
        EditText editTextOne = findViewById(R.id.elementEdit41);
        EditText editTextTwo = findViewById(R.id.elementEdit42);
        EditText editTextThree = findViewById(R.id.elementEdit43);
        Button buttonUpload = findViewById(R.id.elementButton);
        DAOPosition daoFour = new DAOPosition();
        buttonUpload.setOnClickListener(v->{
            Position pos = new Position(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            daoFour.add(pos).addOnSuccessListener(suc->{
                Toast.makeText(this,"Record inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}