public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor(Automovil.COLOR_BLANCO);

        Automovil mazda = new Automovil("Mazda", "BT-50", Automovil.COLOR_ROJO, 3.0);
        System.out.println("mazda.leerFabricante() = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara", Automovil.COLOR_GRIS, 3.5, 50);

        Automovil nissan2 = new Automovil("Nissan", "Navara", Automovil.COLOR_GRIS, 3.5, 50);
        nissan2.setColor(Automovil.COLOR_AMARILLO);
        Automovil.setColorPatente(Automovil.COLOR_AZUL);

        Automovil auto = new Automovil();

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(nissan2.verDetalle());
        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("kilómetros por litros = " + Automovil.calcularConsumoEstatico(300, 60));
        System.out.println("Velocidad máxima carretera: " + Automovil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("Velocidad máxima ciudad: " + Automovil.VELOCIDAD_MAX_CIUDAD);
    }
}
