package com.demo.tareas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDFController {
    private final ExportPDFService expPDF;

    public PDFController (
            ExportPDFService expPDF
    ){
        this.expPDF = expPDF;
    }

    @GetMapping("/PDFSMS")
    public String pdfEmailSMS(){
        return expPDF.exportarPDF("SMS","wazaaaa");
    }

    @GetMapping("/PDFMail")
    public String pdfEmailMail(){
        return expPDF.exportarPDFMail("Mail","balatro");
    }

    @GetMapping("/PDFRed")
    public String pdfEmailRed(){
        return expPDF.exportarPDFRed("Facebook", "Genshin se la impacto");
    }

}
