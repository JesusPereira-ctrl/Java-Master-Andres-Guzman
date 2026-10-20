import java.util.Map;

public class EjemploVariablesEntorno {
    public static void main() {

        Map<String, String> varEnv = System.getenv();
        System.out.println("Variables de ambiente del sistema = " + varEnv);

        System.out.println("---------- Listando variables del entorno del sistema ----------");
        for (String key : varEnv.keySet()) {
            System.out.println(key + " => " + varEnv.get(key));
        }

        String username = varEnv.get("USERNAME");
        System.out.println("username = " + username);

        String javaHome = varEnv.get("JAVA_HOME");
        System.out.println("javaHome = " + javaHome);

        String tempDir = varEnv.get("TEMP_DIR");
        System.out.println("tempDir = " + tempDir);

        String path = varEnv.get("Path");
        System.out.println("path = " + path);

        String path2 = varEnv.get("Path");
        System.out.println("path2 = " + path2);

        String appEnv = varEnv.get("APPLICATION_ENV");
        System.out.println("appEnv = " + appEnv);

        String hola = varEnv.get("SALUDAR_HOLA");
        System.out.println("hola = " + hola);
    }
}
