package com.demo.tareas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExportPDFService {
    private final PDFSMS pdfsms;
    private final PDFRED pdfred;
    private final PDFMail pdfmail;

    public ExportPDFService (
            @Qualifier("pdfsms") PDFSMS pdfsms,
            @Qualifier("pdfred") PDFRED pdfred,
            @Qualifier("pdfmail") PDFMail pdfmail
    ){
        this.pdfsms = pdfsms;
        this.pdfmail = pdfmail;
        this.pdfred = pdfred;
    }

    public String exportarPDF(String servicio, String info){
        return pdfsms.exportarPDF(servicio,info);
    }

    public String exportarPDFMail(String servicio, String info){
        return pdfmail.exportarPDF(servicio,info);
    }

    public String exportarPDFRed(String servicio, String info){
        return pdfred.exportarPDF(servicio,info);
    }

}
