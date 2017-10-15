package com.example.jl.lilprinter.data;

import android.os.Bundle;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterFirebaseAdapter {
    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;

    public PrinterFirebaseAdapter() {
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");
    }
    public void writePrinter(Printer printer) {
        String key = printerCloudEndPoint.push().getKey();
        printer.setId(key);
        printerCloudEndPoint.child(key).setValue(printer);
    }

    public void removePrinter(Printer printer) {
        String key = printer.getId();
        printerCloudEndPoint.child(key).removeValue();
    }

}
