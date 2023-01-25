package com.example.crud2;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOComputer {
    private DatabaseReference databaseReference;
    public DAOComputer(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Computer.class.getSimpleName());
    }
    public Task<Void> add(Computer com){
        return databaseReference.push().setValue(com);
    }
}
