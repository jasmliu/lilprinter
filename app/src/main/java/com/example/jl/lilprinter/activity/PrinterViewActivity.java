package com.example.jl.lilprinter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterViewActivity extends AppCompatActivity {
    private Printer printer;

    TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_view);

        printer = getIntent().getExtras().getParcelable("printer");

        //display location for now
        locationText = (TextView) findViewById(R.id.location);
        String location = printer.getLocation();
        locationText.setText(location);

        //todo: ui design
    }
}
