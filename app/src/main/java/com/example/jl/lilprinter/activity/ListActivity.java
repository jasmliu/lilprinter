package com.example.jl.lilprinter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.adapter.PrinterViewHolder;
import com.example.jl.lilprinter.data.PrinterAdapter;
import com.example.jl.lilprinter.model.Printer;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";

    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;

    private List<Printer> mPrinters;

    private PrinterAdapter mPrinterAdapter;

    private FirebaseRecyclerAdapter mPrinterFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");

        //list of printers pulled from database
        mPrinters = new ArrayList<>();

        //recyclerview
        RecyclerView mPrinterRecyclerView = findViewById(R.id.printer_recycler_view);
        mPrinterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPrinterRecyclerView.setHasFixedSize(true);

        Query query = FirebaseDatabase.getInstance().getReference().child("printer");
        FirebaseRecyclerOptions<Printer> options = new FirebaseRecyclerOptions.Builder<Printer>().setQuery(query, Printer.class).setLifecycleOwner(this).build();
        Log.d(TAG, "RECYCLERVIEWSUCCESS");

        mPrinterFirebaseAdapter = new FirebaseRecyclerAdapter<Printer, PrinterViewHolder>(options) {
            @Override
            public PrinterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.d(TAG, "RECYCLERVIEWSUCCESS");
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.printer_custom_row, parent, false);
                return new PrinterViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(PrinterViewHolder holder, int position, Printer printer) {
                holder.bind(printer);
            }
        };

        mPrinterRecyclerView.setAdapter(mPrinterFirebaseAdapter);

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


    }

}

//initial printer data add; disregard
/**
 mPrinterAdapter = new PrinterAdapter();
 for (Printer p : new Printers().getPrinters()) {
 mPrinterAdapter.writePrinter(p);
 }**/
