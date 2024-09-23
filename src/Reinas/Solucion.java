package Reinas;
import java.util.Arrays;

public class Solucion implements Comparable<Solucion> {

    public int[] permutacion;
    public int ataques;

    public Solucion(int D) {
        permutacion = new int[D];
        ataques = 0;
    }

    @Override
    public int compareTo(Solucion t) {
        return Integer.compare(t.ataques, ataques);
    }

    @Override
    public String toString() {
        return Arrays.toString(permutacion) + " Ataques: " + ataques;
    }
}
