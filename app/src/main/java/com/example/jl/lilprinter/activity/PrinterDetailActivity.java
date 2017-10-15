package com.example.jl.lilprinter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterDetailActivity extends AppCompatActivity {
    private Printer printer;

    TextView typeText;
    ImageButton paperStatus;
    ImageButton jamStatus;
    ImageButton inkStatus;
    ImageButton computerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_view);

        printer = getIntent().getExtras().getParcelable("printer");

        typeText = (TextView) findViewById(R.id.txtView_color);
        typeText.setText(printer.getType());

        paperStatus = findViewById(R.id.btn_paperStatus);
        if(!printer.getPaperStatus()) {
            paperStatus.setImageResource(R.drawable.error);
        }

        jamStatus = findViewById(R.id.btn_jamStatus);
        if(!printer.getJamStatus()) {
            jamStatus.setImageResource(R.drawable.error);
        }

        inkStatus = findViewById(R.id.btn_inkStatus);
        if(!printer.getInkStatus()) {
            inkStatus.setImageResource(R.drawable.error);
        }

        computerStatus = findViewById(R.id.btn_computerStatus);
        if(!printer.getComputerStatus()) {
            paperStatus.setImageResource(R.drawable.error);
        }

    }


}
