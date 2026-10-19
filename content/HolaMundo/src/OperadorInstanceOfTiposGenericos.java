public class OperadorInstanceOfTiposGenericos {
    public static void main(String[] args) {

        Object texto = "Creando un objeto de la clase String ... que tal!";
        Number num = Integer.valueOf(7); // 7;
        Number decimal = Float.valueOf(45.54f);
        Boolean bool = true;

        boolean b1 = texto instanceof String;
        System.out.println("texto es del tipo String = " + b1);

        boolean b2 = texto instanceof Object;
        System.out.println("texto es del tipo Object = " + b2);

        boolean b3 = texto instanceof Integer;
        System.out.println("texto es del tipo Integer = " + b3);

        boolean b4 = num instanceof Integer;
        System.out.println("num es del tipo Integer = " + b4);

        boolean b5 = num instanceof Number;
        System.out.println("num es del tipo Number = " + b5);

        boolean b6 = num instanceof Object;
        System.out.println("num es del tipo Object = " + b6);

        boolean b7 = num instanceof Long;
        System.out.println("num es del tipo Long = " + b7);

        boolean b8 = num instanceof Double;
        System.out.println("num es del tipo Double = " + b8);

        boolean b9 = decimal instanceof Double;
        System.out.println("decimal es del tipo Double = " + b9);

        boolean b10 = decimal instanceof Float;
        System.out.println("decimal es del tipo Float = " + b10);

        boolean b11 = decimal instanceof Integer;
        System.out.println("decimal es del tipo Integer = " + b11);

        boolean b12 = decimal instanceof Number;
        System.out.println("decimal es del tipo Number = " + b12);

        boolean b13 = bool instanceof Boolean;
        System.out.println("bool es del tipo Boolean = " + b13);
    }
}
