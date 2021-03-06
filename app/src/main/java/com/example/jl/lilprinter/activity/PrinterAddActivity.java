package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.data.PrinterFirebaseAdapter;
import com.example.jl.lilprinter.model.Printer;

public class PrinterAddActivity extends AppCompatActivity {

    ImageButton paperStatus;
    ImageButton jamStatus;
    ImageButton inkStatus;
    ImageButton computerStatus;
    Button update;
    Printer printer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_add);

        printer = new Printer();

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
            paperStatus.setImageResource(R.drawable.error);
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
                PrinterFirebaseAdapter db = new PrinterFirebaseAdapter();
                db.writePrinter(printer);
                Intent intent = new Intent(PrinterAddActivity.this, PrinterRecyclerViewActivity.class);
                intent.putExtra("user", getIntent().getStringExtra("user"));
                intent.putExtra("printer", printer);
                startActivity(intent);
            }
        });


    }
}
