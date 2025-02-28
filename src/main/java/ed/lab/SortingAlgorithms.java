package ed.lab;
import java.util.Random;

public class SortingAlgorithms {

    private static final Random random = new Random(); // Para pivote aleatorio

    //  QuickSort con el último elemento como pivote
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    //  QuickSort con el primer elemento como pivote
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    //  QuickSort con un pivote aleatorio
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    // Método privado de QuickSort
    private static <T extends Comparable<T>> void quickSort(T[] array, int inicio, int fin, String pivotType) {
        if (inicio < fin) {
            int pivoteIndex = particionar(array, inicio, fin, pivotType);
            quickSort(array, inicio, pivoteIndex - 1, pivotType);
            quickSort(array, pivoteIndex + 1, fin, pivotType);
        }
    }

    // Método de partición
    private static <T extends Comparable<T>> int particionar(T[] array, int inicio, int fin, String pivotType) {
        int pivoteIndex;

        if ("high".equals(pivotType)) {
            pivoteIndex = fin;
        } else if ("low".equals(pivotType)) {
            pivoteIndex = inicio;
        } else {
            pivoteIndex = random.nextInt(fin - inicio + 1) + inicio;
        }

        intercambiar(array, pivoteIndex, fin);
        T pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j].compareTo(pivote) <= 0) {
                i++;
                intercambiar(array, i, j);
            }
        }

        intercambiar(array, i + 1, fin);
        return i + 1;
    }

    // Método de intercambio
    private static <T> void intercambiar(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}