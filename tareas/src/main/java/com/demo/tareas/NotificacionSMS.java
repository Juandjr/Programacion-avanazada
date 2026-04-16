package com.demo.tareas;

import org.springframework.stereotype.Service;

@Service("notificacionSMS")
public class NotificacionSMS implements MSGService {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje){
        System.out.println("Enviando al numero " + destinatario + " el mensaje: " + mensaje);
    }
}
