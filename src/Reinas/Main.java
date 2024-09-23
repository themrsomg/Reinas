package Reinas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite las medidas del tablero: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Busqueda busqueda = new Busqueda(size);

        Solucion solucion = busqueda.Algoritmo();
        System.out.println("Solución final: " + solucion);
    }
}
