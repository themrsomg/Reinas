package Reinas;

import static Reinas.Aleatorio.rnd;

public class Busqueda {

    Tablero tablero;

    public Busqueda(int size) {
        tablero = new Tablero(size);
    }

    /**
     * Algoritmo de búsqueda para encontrar una solución con cero ataques
     * utilizando Hill Climbing
     * @return Solución con cero ataques o la mejor solución encontrada
     */
    public Solucion Algoritmo() {
        Solucion actual = tablero.s;
        int iteraciones = 10000;
        while (actual.ataques > 0 && iteraciones > 0) {
            Solucion nueva = Tweak(actual);
            if (nueva.ataques <= actual.ataques) {
                actual = nueva;
            }
            iteraciones--;
        }
        return actual;
    }

    private Solucion Tweak(Solucion s) {
        Solucion s1 = new Solucion(tablero.size);
        s1.permutacion = s.permutacion.clone();

        int p1 = rnd(0, tablero.size - 1);
        int p2 = rnd(0, tablero.size - 1);

        while (p1 == p2) {
            p1 = rnd(0, tablero.size - 1);
        }
        int temp = s1.permutacion[p1];
        s1.permutacion[p1] = s1.permutacion[p2];
        s1.permutacion[p2] = temp;
        s1.ataques = tablero.contarAtaques(s1.permutacion);

        return s1;
    }
}
