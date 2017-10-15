package com.example.jl.lilprinter.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.activity.PrinterViewActivity;
import com.example.jl.lilprinter.model.Printer;

import java.util.List;

/**
 * Created by jav on 10/14/2017.
 */

public class PrinterRecyclerViewAdapter extends RecyclerView.Adapter<PrinterRecyclerViewAdapter.ViewHolder> {
    private List<Printer> printerList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView location, type, status;
        public Printer printer;

        public ViewHolder(View view) {
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
    }

    public PrinterRecyclerViewAdapter(List<Printer> printers) {
        this.printerList = printers;
    }

    @Override
    public PrinterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View printerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.printer_custom_row, parent, false);
        return new ViewHolder(printerView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Printer printer = printerList.get(position);
        holder.printer = printer;
        holder.location.setText(printer.getLocation());
        holder.type.setText(printer.getType());
        holder.status.setText(String.valueOf(printer.getStatus()));
    }

    @Override
    public int getItemCount() {
        return printerList.size();
    }
}
