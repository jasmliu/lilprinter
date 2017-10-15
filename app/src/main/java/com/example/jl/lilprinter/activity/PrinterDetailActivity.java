package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.firebase.auth.FirebaseAuth;

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



        FloatingActionButton edit = findViewById(R.id.fabEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    Intent intent = new Intent(view.getContext(), PrinterEditActivity.class);
                    intent.putExtra("user", getIntent().getExtras().getString("user"));
                    intent.putExtra("printer", printer);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(view.getContext(), LoginActivity.class);
                    intent.putExtra("user", getIntent().getExtras().getString("user"));
                    startActivity(intent);
                }
            }
        });

    }



}
