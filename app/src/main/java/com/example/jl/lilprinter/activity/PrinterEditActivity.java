package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PrinterEditActivity extends AppCompatActivity {

    ImageButton paperStatus;
    ImageButton jamStatus;
    ImageButton inkStatus;
    ImageButton computerStatus;
    Button update;
    Printer printer;

    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_edit);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");

        printer = getIntent().getExtras().getParcelable("printer");

        paperStatus = findViewById(R.id.btn_paperStatus);
        if(!printer.getPaperStatus()) {
            paperStatus.setImageResource(R.drawable.error);
        }
        paperStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printer.setPaperStatus(!printer.getPaperStatus());

                if (!printer.getPaperStatus()) {
                    paperStatus.setImageResource(R.drawable.error);
                } else {
                    paperStatus.setImageResource(R.drawable.checkmark);
                }
            }
        });

        jamStatus = findViewById(R.id.btn_jamStatus);
        if(!printer.getJamStatus()) {
            jamStatus.setImageResource(R.drawable.error);
        }
        jamStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printer.setJamStatus(!printer.getJamStatus());
                if (!printer.getJamStatus()) {
                    jamStatus.setImageResource(R.drawable.error);
                } else {
                    jamStatus.setImageResource(R.drawable.checkmark);
                }
            }
        });

        inkStatus = findViewById(R.id.btn_inkStatus);
        if(!printer.getInkStatus()) {
            inkStatus.setImageResource(R.drawable.error);
        }
        inkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printer.setInkStatus(!printer.getInkStatus());
                if (!printer.getInkStatus()) {
                    inkStatus.setImageResource(R.drawable.error);
                } else {
                    inkStatus.setImageResource(R.drawable.checkmark);
                }
            }
        });

        computerStatus = findViewById(R.id.btn_computerStatus);
        if(!printer.getComputerStatus()) {
            computerStatus.setImageResource(R.drawable.error);
        }
        computerStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printer.setComputerStatus(!printer.getComputerStatus());
                if (!printer.getComputerStatus()) {
                    computerStatus.setImageResource(R.drawable.error);
                } else {
                    computerStatus.setImageResource(R.drawable.checkmark);
                }
            }
        });



        update = findViewById(R.id.btn_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (printer.getComputerStatus() && printer.getPaperStatus() && printer.getInkStatus() && printer.getJamStatus()) {
                    printer.setStatus(true);
                } else {
                    printer.setStatus(false);
                }
                Intent intent = new Intent(PrinterEditActivity.this, PrinterDetailActivity.class);
                intent.putExtra("user", getIntent().getStringExtra("user"));
                intent.putExtra("printer", printer);
                printerCloudEndPoint.child(printer.getId()).setValue(printer);
                startActivity(intent);
            }
        });



    }
}
