package org.aguzman.patrones.decorator;

import org.aguzman.patrones.decorator.decorador.MayusculaDecorador;
import org.aguzman.patrones.decorator.decorador.ReemplazarEspacioDecorador;
import org.aguzman.patrones.decorator.decorador.ReversaDecorador;
import org.aguzman.patrones.decorator.decorador.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {

        Formateable texto = new Texto("Hola que tal Andrés!");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reversa);
        ReemplazarEspacioDecorador reemplazar = new ReemplazarEspacioDecorador(subrayar);

        System.out.println(reemplazar.darFormato());
    }
}
