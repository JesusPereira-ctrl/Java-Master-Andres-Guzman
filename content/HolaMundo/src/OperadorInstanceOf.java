public class OperadorInstanceOf {
    public static void main(String[] args) {

        String texto = "Creando un objeto de la clase String ... que tal!";
        Integer num = 7;
        Double decimal = 45.54;
        Boolean bool = true;

        boolean b1 = texto instanceof String;
        System.out.println("texto es del tipo String = " + b1);

        boolean b2 = texto instanceof Object;
        System.out.println("texto es del tipo Object = " + b2);

        boolean b3 = num instanceof Integer;
        System.out.println("num es del tipo Integer = " + b3);

        boolean b4 = num instanceof Number;
        System.out.println("num es del tipo Number = " + b4);

        boolean b5 = num instanceof Object;
        System.out.println("num es del tipo Object = " + b5);

        boolean b6 = decimal instanceof Number;
        System.out.println("decimal es del tipo Number = " + b6);

        boolean b7 = bool instanceof Boolean;
        System.out.println("bool es del tipo Boolean = " + b7);
    }
}
