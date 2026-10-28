package org.aguzman.genericsclass;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion transporteCaballos = new Camion(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        for (Object o : transporteCaballos) {
            Animal a = (Animal) o;
            System.out.println(a.getNombre() + " tipo: " + a.getTipo());
        }

        Camion transporteMaquinarias = new Camion(3);
        transporteMaquinarias.add(new Maquinaria("Bulldozer"));
        transporteMaquinarias.add(new Maquinaria("Grúa Horquilla"));
        transporteMaquinarias.add(new Maquinaria("Perforadora"));

        for (Object o : transporteMaquinarias) {
            Maquinaria m = (Maquinaria) o;
            System.out.println(m.getTipo());
        }

        Camion transporteAutos = new Camion(3);
        transporteAutos.add(new Automovil("Toyota"));
        transporteAutos.add(new Automovil("Mitsubishi"));
        transporteAutos.add(new Automovil("Chevrolet"));

        for (Object o : transporteAutos) {
            Automovil a = (Automovil) o;
            System.out.println(a.getMarca());
        }
    }
}
