package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
        DAOComputer daoThree = new DAOComputer();
        Computer com_edit = (Computer)getIntent().getSerializableExtra("EDIT");
        if(com_edit != null)
        {
            buttonUpload.setText("UPDATE");
            editTextOne.setText(com_edit.getComName());
            editTextTwo.setText(com_edit.getYear());
            editTextThree.setText(com_edit.getNeedsFixing());

        }
        else{
            buttonUpload.setText("SUBMIT");

        }

        buttonUpload.setOnClickListener(v->{
            Computer com = new Computer(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            if(com_edit==null) {
                daoThree.add(com).addOnSuccessListener(suc -> {
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
                daoThree.update(com_edit.getKey(), hashMap).addOnSuccessListener(suc->{
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