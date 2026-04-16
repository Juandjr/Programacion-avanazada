package com.demo.tareas;

import org.springframework.stereotype.Service;

@Service("pdfred")
public class PDFRED implements PDFService {
    @Override
    public String exportarPDF(String servicio, String info) {
        return "<h1>Se exporta desde "+ servicio +" : "+info+"</h1>";
    }
}
