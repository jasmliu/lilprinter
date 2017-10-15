package com.example.jl.lilprinter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;

public class PrinterEditActivity extends AppCompatActivity {

    ImageButton paperStatus;
    ImageButton jamStatus;
    ImageButton inkStatus;
    ImageButton computerStatus;
    Printer printer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_edit);

        printer = getIntent().getExtras().getParcelable("printer");

        paperStatus = findViewById(R.id.btn_paperStatus);


        jamStatus = findViewById(R.id.btn_jamStatus);

        inkStatus = findViewById(R.id.btn_inkStatus);

        computerStatus = findViewById(R.id.btn_computerStatus);

    }
}
