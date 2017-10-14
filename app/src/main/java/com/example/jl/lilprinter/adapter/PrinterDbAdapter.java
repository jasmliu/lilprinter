package com.example.jl.lilprinter.adapter;

import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterDbAdapter {

    public static String getPrinterLocation(final int printerId) {
        final String loc;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("printers").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loc = dataSnapshot.child(Integer.toString(printerId)).getValue(String.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    return;
                }
            }
        );

    }
}
