package org.aguzman.patrones.factory;

import org.aguzman.patrones.factory.producto.PizzaNewYorkItaliana;
import org.aguzman.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.aguzman.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {

    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo) {
            case "vegetariana":
                producto = new PizzaNewYorkVegetariana();
                break;
            case "pepperoni":
                producto = new PizzaNewYorkPepperoni();
                break;
            case "italiana":
                producto = new PizzaNewYorkItaliana();
                break;
        }
        return producto;
    }
}
