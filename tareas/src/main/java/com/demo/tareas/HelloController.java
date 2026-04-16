package com.demo.tareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final NotificacionService notificacionService;

    @Autowired
    public HelloController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping("/notificar")
    public String enviarNotificacion() {
        notificacionService.notificarUsuario("juan@email.com", "Hola desde Spring 🚀");
        return "<h2>Notificación enviada por Email</h2>";
    }

    @GetMapping("/notificar-sms")
    public String enviarSMS() {
        notificacionService.notificarUsuarioSMS("999999999", "SMS enviado 📱");
        return "<h2>Notificación SMS enviada</h2>";
    }

    @GetMapping("/notificar-red")
    public String enviarRedSocial() {
        notificacionService.notificarUsuarioRedSocial("juan123", "Mensaje en red social 💬");
        return "<h2>Notificación en red social enviada</h2>";
    }
}

