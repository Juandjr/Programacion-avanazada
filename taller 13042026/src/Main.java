public class Main {
    public static void main(String[] args) {
        NotificacionService servicio = new NotificacionService();
        servicio.notificarUsuario("juan@mail.com","Hola mundo");
        servicio.notificarUsuarioSMS("0962745941", "wazaaaaa");
        servicio.notificarUsuarioRedSocial("Juan_Horse", "When haces codigo en java :P");
    }
}