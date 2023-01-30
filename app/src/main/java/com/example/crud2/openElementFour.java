package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class openElementFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_element_four);

        final DatabaseReference[] databaseReference = new DatabaseReference[4];
        EditText editTextOne = findViewById(R.id.elementEdit41);
        EditText editTextTwo = findViewById(R.id.elementEdit42);
        EditText editTextThree = findViewById(R.id.elementEdit43);
        Button buttonUpload = findViewById(R.id.elementButton);
        DAORoom daoFour = new DAORoom();
        Room room_edit = (Room)getIntent().getSerializableExtra("EDIT");
        if(room_edit != null)
        {
            buttonUpload.setText("UPDATE");
            editTextOne.setText(room_edit.getNumber());
            editTextTwo.setText(room_edit.getHasWiFi());
            editTextThree.setText(room_edit.getIsSecured());

        }
        else{
            buttonUpload.setText("SUBMIT");

        }

        buttonUpload.setOnClickListener(v->{
            Room room = new Room(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            if(room_edit==null) {
                daoFour.add(room).addOnSuccessListener(suc -> {
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
                daoFour.update(room_edit.getKey(), hashMap).addOnSuccessListener(suc->{
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