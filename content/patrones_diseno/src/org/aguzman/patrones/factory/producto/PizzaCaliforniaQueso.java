package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa A La Piedra Delgada";
        salsa = "Salsa De Tomate Rúcula";
        ingredientes.add("Extra Queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso Azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35 min. a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triángulos");
    }
}
