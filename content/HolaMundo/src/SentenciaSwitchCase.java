public class SentenciaSwitchCase {
    public static void main(String[] args) {

        char num = 'z';

        switch (num) {
            case '0':
                System.out.println("El num es cero");
                break;
            case '1':
                System.out.println("El num es uno");
                break;
            case '2':
                System.out.println("El num es dos");
                break;
            case '3':
                System.out.println("El num es tres");
                break;
            case 'a':
                System.out.println("El carácter es a");
                break;
            default:
                System.out.println("Número o carácter desconocido");
        }

        String nombre = "juan";

        switch (nombre) {
            case "admin":
                System.out.println("Hola admin, bienvenido!");
                break;
            case "andres":
                System.out.println("Hola andres!");
                break;
            case "pepe":
                System.out.println("Hola pepe");
                break;
            default:
                System.out.println("Usuario desconocido!");
        }
    }
}
