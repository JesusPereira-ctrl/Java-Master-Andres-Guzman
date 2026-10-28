package org.aguzman.pooexcepciones.ejemplo;

public class Calculadora {

    public double dividir(int numerador, int divisor) throws DivisionPorZeroException {
        if (divisor == 0) {
            throw new DivisionPorZeroException("no se puede dividir por cero!");
        }
        return numerador / (double) divisor;
    }
}
