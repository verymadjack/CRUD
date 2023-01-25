package com.example.crud2;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAORoom {
    private DatabaseReference databaseReference;
    public DAORoom(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Room.class.getSimpleName());
    }
    public Task<Void> add(Room roo){
        return databaseReference.push().setValue(roo);
    }
}
