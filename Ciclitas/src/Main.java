public class Main {
    public static void main(String[] args) {
        Velocista velocista = new Velocista(20, "Jose", 2.4, 5.4);
        Escalador escalador = new Escalador(12, "Manolo", 3, 4);
        Contrarrelojista contr = new Contrarrelojista(15, "Luis", 3.4);

        Equipo equipo = new Equipo("Cocos italianos", "Italia");
        equipo.agregarCiclista(velocista);
        equipo.agregarCiclista(escalador);
        System.out.println(equipo.buscarCiclista(20));
        System.out.println(equipo.buscarCiclista(15));
        System.out.println();
        equipo.imprimirDatosEquipo();
        System.out.println();
        equipo.listaJugadores();
        System.out.println(velocista.imprimirTipo());
        System.out.println(escalador.imprimirTipo());
        System.out.println(contr.imprimirTipo());
    }
}
