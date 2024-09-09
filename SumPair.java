import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SumPair {

    // Función para contar pares que cumplan la condición
    public static int sumPair(int[] v, int[] pares) {
        int result = 0;
        int operaciones = 0; // Contador de operaciones
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                operaciones++;
                if ((v[i] + v[j]) % 2 == 0) {
                    result++; // Aumentamos el contador de pares
                }
            }
        }
        pares[0] = result; // Guardamos el número de pares encontrados
        return operaciones; // Retornamos el número de operaciones
    }

    public static void main(String[] args) {
        int n = 10; // Cambia este valor a un número grande si lo prefieres
        // entre mas grande sea el  valor del vetor mayor es el tiempo de cpu, y el  tiempo de ejecucion sear mas lento
        int[] vector = new int[n];
        int[] pares = {0}; // Variable para almacenar el número de pares
        Random random = new Random(); // Objeto para generar números aleatorios

        // Rellenar el vector con valores aleatorios
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextInt(100); // Números aleatorios entre 0 y 99
        }
//     calcular el tiempo de cpu
        long startTime = System.nanoTime();

        int operaciones = sumPair(vector, pares);

        long endTime = System.nanoTime();
        long tiempoEjecucionNano = endTime - startTime;
        double tiempoEjecucionMs = tiempoEjecucionNano / 1_000_000.0;

        // Escribir los resultados en un archivo
        try (FileWriter fileWriter = new FileWriter("resultados.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println("Tamaño del vector (n): " + n);
            //printWriter.println("Elementos del vector: " + Arrays.toString(vector)); // Mostrar los elementos del vector
            printWriter.println("Número de pares encontrados: " + pares[0]); // Mostrar número de pares
            printWriter.println("Número de operaciones: " + operaciones);
            printWriter.println("Tiempo CPU (milisegundos): " + tiempoEjecucionMs);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}