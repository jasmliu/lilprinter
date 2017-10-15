package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.adapter.PrinterRecyclerViewAdapter;
import com.example.jl.lilprinter.data.PrinterFirebaseAdapter;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PrinterRecyclerViewActivity extends AppCompatActivity {
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
        Log.d(TAG, getIntent().getStringExtra("user"));
        if (getIntent().getStringExtra("user").equals("ADMIN")) {
            setContentView(R.layout.activity_list_admin);
        } else {
            setContentView(R.layout.activity_list_user);
        }


        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");

//        Printers printers = new Printers();
//        for (Printer p : printers.getPrinters()) {
//            PrinterFirebaseAdapter db =new PrinterFirebaseAdapter();
//            db.writePrinter(p);
//        }
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                PrinterFirebaseAdapter db =new PrinterFirebaseAdapter();
                Printer printer = ((PrinterRecyclerViewAdapter.ViewHolder) viewHolder).printer;
                db.removePrinter(printer);
                Log.d(TAG, "array size " + mPrinters.size());
                dataRead();
                Log.d(TAG, "array size: " + mPrinters.size());
            }
        };
        ItemTouchHelper iTH = new ItemTouchHelper(simpleItemTouchCallback);

        if (getIntent().getStringExtra("user").equals("ADMIN")) {
            FloatingActionButton addFab = findViewById(R.id.fabAdd);

            addFab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PrinterAddActivity.class);
                    intent.putExtra("user", getIntent().getStringExtra("user"));
                    startActivity(intent);
                }
            });

        }

        mRecyclerView = findViewById(R.id.printer_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent().getStringExtra("user").equals("ADMIN")) {
            iTH.attachToRecyclerView(mRecyclerView);
        }
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
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                        Printer printer = printerSnapshot.getValue(Printer.class);
                        mPrinters.add(printer);
                        mAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Log.d(TAG, String.valueOf(mPrinters.remove(dataSnapshot.getValue(Printer.class))));
                    mAdapter.notifyDataSetChanged();
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