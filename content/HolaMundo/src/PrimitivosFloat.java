public class PrimitivosFloat {
    public static void main(String[] args) {

        float realFloat = 0.00000000015f; // 1.5e-10f;
        System.out.println("realFloat = " + realFloat);
        System.out.println("float corresponde en bytes a " + Float.BYTES);
        System.out.println("float corresponde en bits a " + Float.SIZE);
        System.out.println("máximo valor para float " + Float.MAX_VALUE);
        System.out.println("mínimo valor para float " + Float.MIN_VALUE);

        double realDouble = 1.7976931348623157E308;
        System.out.println("realDouble = " + realDouble);
        System.out.println("double corresponde en bytes a " + Double.BYTES);
        System.out.println("double corresponde en bits a " + Double.SIZE);
        System.out.println("máximo valor para double " + Double.MAX_VALUE);
        System.out.println("mínimo valor para double " + Double.MIN_VALUE);

        float varFlotante = 3.1416f;
        System.out.println("varFlotante = " + varFlotante);
    }
}
