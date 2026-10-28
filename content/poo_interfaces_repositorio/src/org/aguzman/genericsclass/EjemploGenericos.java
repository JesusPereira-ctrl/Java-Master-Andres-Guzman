package org.aguzman.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println(((Animal) a).getNombre() + " tipo: " + ((Animal) a).getTipo());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            }
        }
    }

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transporteMaquinarias = new Camion<>(3);
        transporteMaquinarias.add(new Maquinaria("Bulldozer"));
        transporteMaquinarias.add(new Maquinaria("Grúa Horquilla"));
        transporteMaquinarias.add(new Maquinaria("Perforadora"));

        imprimirCamion(transporteMaquinarias);

        Camion<Automovil> transporteAutos = new Camion<>(3);
        transporteAutos.add(new Automovil("Toyota"));
        transporteAutos.add(new Automovil("Mitsubishi"));
        transporteAutos.add(new Automovil("Chevrolet"));

        imprimirCamion(transporteAutos);
    }
}
