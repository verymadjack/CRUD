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

public class openElementOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_element_one);

        final DatabaseReference[] databaseReference = new DatabaseReference[1];
        EditText editTextOne = findViewById(R.id.elementOneEdit1);
        EditText editTextTwo = findViewById(R.id.elementOneEdit2);
        EditText editTextThree = findViewById(R.id.elementOneEdit3);
        Button buttonUpload = findViewById(R.id.elementOneButton);
        DAOEmployee daoOne = new DAOEmployee();
        Employee emp_edit = (Employee)getIntent().getSerializableExtra("EDIT");
        if(emp_edit != null)
        {
            buttonUpload.setText("UPDATE");
            editTextOne.setText(emp_edit.getName());
            editTextTwo.setText(emp_edit.getPosition());
            editTextThree.setText(emp_edit.getAge());

        }
        else{
            buttonUpload.setText("SUBMIT");

        }

        buttonUpload.setOnClickListener(v->{
            Employee emp = new Employee(editTextOne.getText().toString(),editTextTwo.getText().toString(),editTextThree.getText().toString());
            if(emp_edit==null) {
                daoOne.add(emp).addOnSuccessListener(suc -> {
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
                daoOne.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc->{
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