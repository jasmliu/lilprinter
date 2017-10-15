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
        woodruff.setLocation("Woodruff");
        woodruff.setLat(33.778967);
        woodruff.setLng(-84.406499);
        printers.add(woodruff);

        Printer fitten = new Printer();
        fitten.setLocation("Fitten");
        fitten.setLat(33.7782);
        fitten.setLng(-84.4037);
        printers.add(fitten);

        Printer stucntr = new Printer();
        stucntr.setLocation("Student Center");
        stucntr.setLat(33.7739);
        stucntr.setLng(-84.3988);
        printers.add(stucntr);

        Printer coc = new Printer();
        coc.setLocation("College of Computing");
        coc.setLat(33.7774);
        coc.setLng(-84.3973);
        printers.add(coc);

        Printer culc2 = new Printer();
        culc2.setLocation("CULC Level 2");
        culc2.setLat(33.7749);
        culc2.setLng(-84.3964);
        printers.add(culc2);

        Printer culc3 = new Printer();
        culc3.setLocation("CULC Level 3");
        culc3.setLat(33.7749);
        culc3.setLng(-84.3964);
        printers.add(culc3);

        Printer culc4 = new Printer();
        culc4.setLocation("CULC Level 4");
        culc4.setLat(33.7749);
        culc4.setLng(-84.3964);
        printers.add(culc4);

        Printer connector = new Printer();
        connector.setLocation("GT Connector Ground Floor");
        connector.setLat(33.7734);
        connector.setLng(-84.3916);
        printers.add(connector);

        Printer nave = new Printer();
        nave.setLocation("North Avenue North");
        nave.setLat(33.7700);
        nave.setLng(-84.3913);
        printers.add(nave);

        Printer glc = new Printer();
        glc.setLocation("Graduate Living Center");
        glc.setLat(33.7818);
        glc.setLng(-84.3963);
        printers.add(glc);

        Printer library1 = new Printer();
        library1.setLocation("Library First Floor");
        library1.setLat(33.7743);
        library1.setLng(-84.3957);
        printers.add(library1);

        Printer library2 = new Printer();
        library2.setLocation("Library First Floor (Color)");
        library2.setLat(33.7743);
        library2.setLng(-84.3957);
        printers.add(library2);

        Printer library3 = new Printer();
        library3.setLocation("Library Second Floor");
        library3.setLat(33.7743);
        library3.setLng(-84.3957);
        printers.add(library3);

        Printer multistudio = new Printer();
        multistudio.setLocation("Multimedia Studio");
        multistudio.setLat(33.7743);
        multistudio.setLng(-84.3957);
        printers.add(multistudio);

    }

    public List<Printer> getPrinters() {
        return printers;
    }
}
