package Reinas;
import java.util.Arrays;

public class Tablero {

    int size;
    int evals = 0;
    Solucion s;
    int[] x;

    public Tablero(int size) {
        this.size = size;
        init();
    }

    private void init() {
        s = new Solucion(size);
        s.permutacion = Aleatorio.getPermutacion(size);
        s.ataques = contarAtaques(s.permutacion);
        evals++;
        x = Arrays.copyOf(s.permutacion, size);
    }

    public int contarAtaques(int[] permutacion) {
        int ataques = 0;
        int n = permutacion.length;

        // Comparar cada reina con las demás
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Verificar si las reinas se atacan en la misma columna o en diagonal
                if (permutacion[i] == permutacion[j] ||
                        Math.abs(permutacion[i] - permutacion[j]) == Math.abs(i - j)) {
                    ataques++;
                }
            }
        }

        return ataques;
    }

    private int[][] getTablero(int[] permutacion) {
        int boardSize = permutacion.length;
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = (permutacion[i] == j) ? 1 : 0;
            }
        }
        return board;
    }
}
