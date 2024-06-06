package aulaenlanube.tema5.ejemplos;

import java.util.Random;

public class ArrayPuntos {

    public static void main(String[] args) {

        Random r = new Random();

        // creamos 5 puntos aleatorios
        Punto[] puntos = new Punto[5];
        Punto p = new Punto(r.nextInt(100), r.nextInt(100));
        for (int i = 0; i < puntos.length; i++) {
            puntos[i] = p;
            puntos[i].mostrarDatos();
        }
        // obtenemos la distancia del punto más lejano del centro(0,0)
        double max = 0;
        for (int i = 0; i < puntos.length; i++) {
            if (max < puntos[i].calcularDistanciaCentro())
                max = puntos[i].calcularDistanciaCentro();
        }
        System.out.println("La distancia máxima del centro es " + max);
        System.out.println(puntos);

    }
}
