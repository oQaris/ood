package factorymethod;

public class RadixSort implements ISort {
    static int getMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    public void sort(int[] arr) {
        int digitPlace = 1;
        int n = arr.length;
        int[] result = new int[n];
        int largestNum = getMax(arr);
        int[] count = new int[10];

        while (largestNum / digitPlace > 0) {

            for (int i = 0; i < 10; i++)
                count[i] = 0;

            for (int j : arr) {
                int tmpIndex = Math.abs((j / digitPlace) % 10);
                count[tmpIndex]++;
            }

            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            for (int i = n - 1; i >= 0; i--) {
                int tmpIndex = Math.abs((arr[i] / digitPlace) % 10);
                result[count[tmpIndex] - 1] = arr[i];
                count[tmpIndex]--;
            }

            System.arraycopy(result, 0, arr, 0, n);
            digitPlace *= 10;
        }
    }
}