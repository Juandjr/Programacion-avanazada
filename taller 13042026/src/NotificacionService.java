public class NotificacionService {
    
    private EmailService emailService;
    private NotificacionSMS notificacionSMS;
    private NotificacionRedSocial notificacionRedSocial;
    
    public NotificacionService() {
        this.emailService = new EmailService();
        this.notificacionSMS = new NotificacionSMS();
        this.notificacionRedSocial = new NotificacionRedSocial();
    }

    public void notificarUsuario(String usuario, String mensaje) {
        emailService.enviarCorreo(usuario, mensaje);
    }

    public void notificarUsuarioSMS(String numero, String mensaje) {
        notificacionSMS.enviarSMS(numero, mensaje);
    }

    public void notificarUsuarioRedSocial(String usuario, String mensaje){
        notificacionRedSocial.enviarRedSocial(usuario, mensaje);
    }

}