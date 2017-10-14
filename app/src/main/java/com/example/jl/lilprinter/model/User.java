package com.example.jl.lilprinter.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by jav on 10/13/2017.
 */

public abstract class User {

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("users");
    public String email;
    public String password;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

        myRef.child("email").setValue(email);
        myRef.child("password").setValue(password);
    }

    private void writeNewUser(String email, String password) {

    }

    public void viewMap() {
        //pull up viewmap screen
        //will be called in onclick for mainmenu (after login) activity:
    }

}
