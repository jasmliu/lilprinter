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
        woodruff.setDescription("Near Dining and Laundry");
        woodruff.setType("B/W");
        woodruff.setLat(33.778967);
        woodruff.setLng(-84.406499);
        printers.add(woodruff);

        Printer fitten = new Printer();
        fitten.setLocation("Fitten");
        fitten.setDescription("McMillan Entrance - Lobby");
        fitten.setType("B/W");
        fitten.setLat(33.7782);
        fitten.setLng(-84.4037);
        printers.add(fitten);

        Printer stucntr = new Printer();
        stucntr.setLocation("Student Center");
        stucntr.setDescription("Computer Cluster - Second Floor");
        stucntr.setType("Color");
        stucntr.setLat(33.7739);
        stucntr.setLng(-84.3988);
        printers.add(stucntr);

        Printer coc = new Printer();
        coc.setLocation("College of Computing");
        coc.setDescription("Across from Room 130");
        coc.setType("B/W");
        coc.setLat(33.7774);
        coc.setLng(-84.3973);
        printers.add(coc);

        Printer culc2 = new Printer();
        culc2.setLocation("CULC Level 2");
        culc2.setDescription("Across from Room 273");
        culc2.setType("B/W");
        culc2.setLat(33.7749);
        culc2.setLng(-84.3964);
        printers.add(culc2);

        Printer culc3 = new Printer();
        culc3.setLocation("CULC Level 3");
        culc3.setDescription("Near Room 385");
        culc3.setType("B/W");
        culc3.setLat(33.7749);
        culc3.setLng(-84.3964);
        printers.add(culc3);

        Printer culc4 = new Printer();
        culc4.setLocation("CULC Level 4");
        culc4.setDescription("Near Grand Stair");
        culc4.setType("B/W");
        culc4.setLat(33.7749);
        culc4.setLng(-84.3964);
        printers.add(culc4);

        Printer connector = new Printer();
        connector.setLocation("GT Connector");
        connector.setDescription("Near Vending");
        connector.setType("B/W");
        connector.setLat(33.7734);
        connector.setLng(-84.3916);
        printers.add(connector);

        Printer nave = new Printer();
        nave.setLocation("North Avenue North");
        nave.setDescription("Inside Housing Office");
        nave.setType("B/W");
        nave.setLat(33.7700);
        nave.setLng(-84.3913);
        printers.add(nave);

        Printer glc = new Printer();
        glc.setLocation("Graduate Living Center");
        glc.setDescription("Activity Room");
        glc.setType("B/W");
        glc.setLat(33.7818);
        glc.setLng(-84.3963);
        printers.add(glc);

        Printer library1 = new Printer();
        library1.setLocation("Library");
        library1.setLocation("Computer Cluster - First Floor");
        library1.setType("Color");
        library1.setLat(33.7743);
        library1.setLng(-84.3957);
        printers.add(library1);

        Printer library2 = new Printer();
        library2.setLocation("Library");
        library2.setLocation("Computer Cluster - First Floor");
        library2.setType("Color");
        library2.setLat(33.7743);
        library2.setLng(-84.3957);
        printers.add(library2);

        Printer library3 = new Printer();
        library3.setLocation("Library");
        library3.setDescription("Second Floor");
        library3.setType("Color");
        library3.setLat(33.7743);
        library3.setLng(-84.3957);
        printers.add(library3);

        Printer library4 = new Printer();
        library4.setLocation("Library");
        library4.setDescription("Third Floor");
        library4.setType("Color");
        library4.setLat(33.7743);
        library4.setLng(-84.3957);
        printers.add(library4);

        Printer multistudio = new Printer();
        multistudio.setLocation("Multimedia Studio");
        multistudio.setDescription("Basement of Library");
        multistudio.setType("Color");
        multistudio.setLat(33.7743);
        multistudio.setLng(-84.3957);
        printers.add(multistudio);

        Printer klaus = new Printer();
        klaus.setLocation("Klaus");
        klaus.setDescription("Room 1446");
        klaus.setType("B/W");
        klaus.setLat(33.7773);
        klaus.setLng(-84.3962);
        printers.add(klaus);

        Printer mrdc = new Printer();
        mrdc.setLocation("MRDC");
        mrdc.setDescription("Computer Lab - Second Floor");
        mrdc.setType("B/W");
        mrdc.setLat(33.7776);
        mrdc.setLng(-84.4013);
        printers.add(mrdc);

        Printer mrdc2 = new Printer();
        mrdc2.setLocation("MRDC");
        mrdc2.setDescription("Room 3328");
        mrdc2.setType("B/W");
        mrdc2.setLat(33.7776);
        mrdc2.setLng(-84.4013);
        printers.add(mrdc2);

        Printer cob = new Printer();
        cob.setLocation("Scheller College of Business");
        cob.setDescription("Computer Lab - First Floor");
        cob.setType("Color");
        cob.setLat(33.7763);
        cob.setLng(-84.3878);
        printers.add(cob);

        Printer susedu = new Printer();
        susedu.setLocation("Sustainable Education");
        susedu.setDescription("Main Lobby");
        susedu.setType("B/W");
        susedu.setLat(33.779);
        susedu.setLng(-84.4048);
        printers.add(susedu);

        Printer vanleer = new Printer();
        vanleer.setLocation("Van Leer");
        vanleer.setDescription("Room C452");
        vanleer.setType("Color");
        vanleer.setLat(33.4633);
        vanleer.setLng(-84.2351);
        printers.add(vanleer);

        Printer arch = new Printer();
        arch.setLocation("Architecture");
        arch.setDescription("Industrial Design Studio");
        arch.setType("Color");
        arch.setLat(33.7761);
        arch.setLng(-84.3961);
        printers.add(arch);

        Printer cherry = new Printer();
        cherry.setLocation("Cherry Emerson");
        cherry.setDescription("Computer Lab - Second Floor");
        cherry.setType("B/W");
        cherry.setLat(33.7779);
        cherry.setLng(-84.3972);
        printers.add(cherry);

        Printer whitaker = new Printer();
        whitaker.setLocation("Whitaker");
        whitaker.setDescription("Basement");
        whitaker.setType("B/W");
        whitaker.setLat(33.7785);
        whitaker.setLng(-84.3967);
        printers.add(whitaker);

        Printer love = new Printer();
        love.setLocation("Love");
        love.setDescription("Computer Lab - First Floor");
        love.setType("B/W");
        love.setLat(33.7766);
        love.setLng(-84.4018);
        printers.add(love);

        Printer groclo = new Printer();
        groclo.setLocation("Groseclose");
        groclo.setDescription("Room 118");
        groclo.setType("B/W");
        groclo.setLat(33.7758);
        groclo.setLng(-84.4019);
        printers.add(groclo);

        Printer isye = new Printer();
        isye.setLocation("ISYE Annex");
        isye.setDescription("Room 126");
        isye.setType("B/W");
        isye.setLat(33.7758);
        isye.setLng(-84.4019);
        printers.add(isye);

        Printer ford = new Printer();
        ford.setLocation("Ford ES&T");
        ford.setDescription("Second Floor");
        ford.setType("B/W");
        ford.setLat(33.7789);
        ford.setLng(-84.396);
        printers.add(ford);

        Printer boggs = new Printer();
        boggs.setLocation("Boggs");
        boggs.setDescription("Room 301");
        boggs.setType("B/W");
        boggs.setLat(33.7757);
        boggs.setLng(-84.3999);
        printers.add(boggs);

        Printer mason = new Printer();
        mason.setLocation("Mason");
        mason.setDescription("Computer Lab - First Floor");
        mason.setType("B/W");
        mason.setLat(33.7766);
        mason.setLng(-84.3984);
        printers.add(mason);

        Printer hinman = new Printer();
        hinman.setLocation("Hinman");
        hinman.setDescription("Lobby");
        hinman.setType("Color");
        hinman.setLat(33.7747);
        hinman.setLng(-84.3953);
        printers.add(hinman);

        Printer biltmore = new Printer();
        biltmore.setLocation("Biltmore");
        biltmore.setDescription("Between E110 and E111");
        biltmore.setType("B/W");
        biltmore.setLat(33.7537);
        biltmore.setLng(-84.3863);
        printers.add(biltmore);

        Printer lang = new Printer();
        lang.setLocation("Language Institute");
        lang.setDescription("Room 113");
        lang.setType("B/W");
        lang.setLat(33.7774);
        lang.setLng(-84.3866);
        printers.add(lang);

    }

    public List<Printer> getPrinters() {
        return printers;
    }
}
