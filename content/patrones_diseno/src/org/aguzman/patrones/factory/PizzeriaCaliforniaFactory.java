package org.aguzman.patrones.factory;

import org.aguzman.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.aguzman.patrones.factory.producto.PizzaCaliforniaQueso;
import org.aguzman.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory {

    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
    }
}
