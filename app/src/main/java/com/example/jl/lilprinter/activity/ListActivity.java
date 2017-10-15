package com.example.jl.lilprinter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.adapter.PrinterRecyclerViewAdapter;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivityError";

    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;

    private List<Printer> mPrinters;

    private ChildEventListener mChildEventListener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");
        mRecyclerView = findViewById(R.id.printer_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPrinters = new ArrayList<>();
        mAdapter = new PrinterRecyclerViewAdapter(mPrinters);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);

        dataRead();
        printerCloudEndPoint.addChildEventListener(mChildEventListener);
    }

    private void dataRead() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Printer printer = dataSnapshot.getValue(Printer.class);
                    mPrinters.add(printer);
                    mAdapter.notifyDataSetChanged();
                    Log.v(TAG, printer.getLocation());
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                        Printer printer = printerSnapshot.getValue(Printer.class);
                        mPrinters.add(printer);
                        mAdapter.notifyDataSetChanged();
                        Log.v(TAG, printer.getLocation());
                    }
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
        }
    }
}