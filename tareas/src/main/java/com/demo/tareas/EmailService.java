package com.demo.tareas;

import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements MSGService {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje){
        System.out.println("Enviando correo a "+ destinatario + " : " + mensaje);
    }

}