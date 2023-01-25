package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class openElementThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_element_three);

        final DatabaseReference[] databaseReference = new DatabaseReference[1];
        EditText editTextOne = findViewById(R.id.elementEdit31);
        EditText editTextTwo = findViewById(R.id.elementEdit32);
        EditText editTextThree = findViewById(R.id.elementEdit33);
        Button buttonUpload = findViewById(R.id.elementButton);
        DAORoom daoThree = new DAORoom();
        buttonUpload.setOnClickListener(v->{
            Room roo = new Room(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            daoThree.add(roo).addOnSuccessListener(suc->{
                Toast.makeText(this,"Record inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}