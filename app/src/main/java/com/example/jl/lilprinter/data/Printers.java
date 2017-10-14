package com.example.jl.lilprinter.data;

import com.example.jl.lilprinter.model.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Initial printer data; disregard
 */

public class Printers {
    private List<Printer> printers;

    public Printers() {
        printers = new ArrayList<>();

        Printer woodruff = new Printer();
        woodruff.setLocation("woodruff");
        woodruff.setLat(33.778967);
        woodruff.setLng(-84.406499);
        printers.add(woodruff);

        Printer library = new Printer();
        library.setLocation("library");
        library.setLat(33.774401);
        library.setLng(-84.395841);
        printers.add(library);

        Printer fitten = new Printer();
        fitten.setLocation("fitten");
        fitten.setLat(33.7782);
        fitten.setLng(-84.4037);
        printers.add(fitten);

        Printer stucntr = new Printer();
        stucntr.setLocation("student center");
        stucntr.setLat(33.7739);
        stucntr.setLng(-84.3988);
        printers.add(stucntr);

        Printer coc = new Printer();
        coc.setLocation("college of computing");
        coc.setLat(33.7774);
        coc.setLng(84.3973);
        printers.add(coc);
    }

    public List<Printer> getPrinters() {
        return printers;
    }
}
