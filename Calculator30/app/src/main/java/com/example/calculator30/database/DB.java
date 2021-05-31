package com.example.calculator30.database;

import com.example.calculator30.objects.Data;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DB {

    private DatabaseReference databaseReference;

    public DB(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Data.class.getSimpleName());
    }

    public Task<Void> add(Data data){
        return databaseReference.push().setValue(data);
    }
}