package com.example.jl.lilprinter.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import com.example.jl.lilprinter.model.Printer;
import android.view.View;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.activity.PrinterViewActivity;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView location, type, status;
    public Printer printer;

    public PrinterViewHolder(View view) {
        super(view);
        location = view.findViewById(R.id.holder_location);
        type = view.findViewById(R.id.holder_type);
        status = view.findViewById(R.id.holder_status);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), PrinterViewActivity.class);
        intent.putExtra("printer", printer);
        v.getContext().startActivity(intent);
    }

    public void bind(Printer printer) {
        this.printer = printer;
        setLocation(printer.getLocation());
        setType(printer.getType());
        setStatus(printer.getStatus());
    }

    private void setLocation(String location) {
        this.location.setText(location);
    }

    private void setType(String type) {
        this.type.setText(type);
    }

    private void setStatus(boolean status) {
        this.status.setText(String.valueOf(status));
    }
}
