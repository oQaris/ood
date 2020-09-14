package factorymethod;

public class SortCreator {

    static ISort selectionSort() {
        return new SelectionSort();
    }

    static ISort heapsort() {
        return new Heapsort();
    }

    static ISort radixSort() {
        return new RadixSort();
    }
}