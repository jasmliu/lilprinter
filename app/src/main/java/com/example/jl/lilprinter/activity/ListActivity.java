package com.example.jl.lilprinter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.data.PrinterAdapter;
import com.example.jl.lilprinter.data.Printers;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";

    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;

    private List<Printer> mPrinters;

    private PrinterAdapter mPrinterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");

        mPrinters = new ArrayList<>();

        printerCloudEndPoint.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                    Printer printer = printerSnapshot.getValue(Printer.class);
                    mPrinters.add(printer);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        //initial printer data add; disregard
        /**
         mPrinterAdapter = new PrinterAdapter();
         for (Printer p : new Printers().getPrinters()) {
         mPrinterAdapter.writePrinter(p);
         }**/
    }

}

