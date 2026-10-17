public class Caracteres {
    public static void main(String[] args) {
        var caracter = '\u0040';
        var decimal = 64;
        System.out.println("carácter = " + caracter);
        System.out.println("decimal = " + decimal);
        System.out.println("decimal == carácter:  " + (decimal == caracter));

        char simbolo = '@';
        System.out.println("símbolo = " + simbolo);
        System.out.println("símbolo == carácter:  " + (simbolo == caracter));

        System.out.println("char corresponde en bytes " + Character.BYTES);
        System.out.println("char corresponde en bits " + Character.SIZE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
    }
}
