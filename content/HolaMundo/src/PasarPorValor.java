public class PasarPorValor {
    public static void main() {

        Integer i = 10;

        System.out.println("Iniciamos el metodo main con i = " + i);
        test(i);
        System.out.println("Finaliza el metodo main con i (se mantiene igual) = " + i);
    }

    public static void test(Integer i) {
        System.out.println("Iniciamos el metodo test con i = " + i);
        i = 35;
        System.out.println("Finaliza el metodo test con i = " + i);
    }
}
