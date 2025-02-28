package ed.lab;

public class    Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = (int length) -> new Integer[]
            {
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            };// Reemplácelo por una función lambda

    private static final ArrayGenerator<Integer> invertedArrayGenerator = (int length) -> new Integer[]
            {
                    10, 9, 8, 7, 6, 5, 4, 3, 2, 1
            };// Reemplácelo por una función lambda

    private static final ArrayGenerator<Integer> randomArrayGenerator = (int length) -> new Integer[]
            {
                    4, 6, 9, 1, 3, 5, 7, 8, 2, 10
            };// Reemplácelo por una función lambda

    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort; // Reemplácelo por una referencia a un método

    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort; 
    }

    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<Integer> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote:  ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}