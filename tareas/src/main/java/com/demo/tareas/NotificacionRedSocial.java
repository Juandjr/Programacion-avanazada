package com.demo.tareas;

import org.springframework.stereotype.Service;

@Service("notificacionRedSocial")
public class NotificacionRedSocial implements MSGService {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje){
        System.out.println("Enviando al Usuario " + destinatario+ " el mensaje: " + mensaje);
    }

}
