package org.aguzman.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String valor = JOptionPane.showInputDialog("Ingrese un entero:");
        int divisor;
        double division;

        try {
            divisor = Integer.parseInt(valor);
            division = cal.dividir(10, divisor);
            System.out.println(division);
        } catch (NumberFormatException nfe) {
            System.out.println("Se detecto una excepción ingrese un valor numérico: " + nfe.getMessage());
            main(args);
        } catch (DivisionPorZeroException ae) {
            System.out.println("Capturamos la excepción en tiempo de ejecución: " + ae.getMessage());
            main(args);
        } finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepción!");
        }
        System.out.println("Continuamos con el flujo de nuestra aplicación!");
    }
}
