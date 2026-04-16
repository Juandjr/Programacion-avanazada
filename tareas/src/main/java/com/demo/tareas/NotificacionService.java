package com.demo.tareas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    private final EmailService emailService;
    private final NotificacionSMS notificacionSMS;
    private final NotificacionRedSocial notificacionRedSocial;

    public NotificacionService(
            @Qualifier("emailService") EmailService emailService,
            @Qualifier("notificacionSMS") NotificacionSMS notificacionSMS,
            @Qualifier("notificacionRedSocial") NotificacionRedSocial notificacionRedSocial, EmailService emailService1, NotificacionSMS notificacionSMS1, NotificacionRedSocial notificacionRedSocial1) {
        this.emailService = emailService;
        this.notificacionSMS = notificacionSMS;
        this.notificacionRedSocial = notificacionRedSocial;
    }

    public void notificarUsuario(String usuario, String mensaje) {
        emailService.enviarNotificacion(usuario, mensaje);
    }

    public void notificarUsuarioSMS(String numero, String mensaje) {
        notificacionSMS.enviarNotificacion(numero, mensaje);
    }

    public void notificarUsuarioRedSocial(String usuario, String mensaje){
        notificacionRedSocial.enviarNotificacion(usuario, mensaje);
    }

}