package arrays;

public class ArraysTest {
    public static int linearSearch(int n, int num, int[] arr) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return index;
    }

    public static int arraysSum(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int findLargest(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
