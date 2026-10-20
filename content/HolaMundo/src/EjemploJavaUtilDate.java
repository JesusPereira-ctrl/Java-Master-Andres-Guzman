import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploJavaUtilDate {
    public static void main() {

        Date fecha = new Date();

        System.out.println("fecha = " + fecha);

        SimpleDateFormat df = new SimpleDateFormat("EEEE dd 'de' MMMM, yyyy");
        String fechaStr = df.format(fecha);

        System.out.println("fechaStr = " + fechaStr);
    }
}
