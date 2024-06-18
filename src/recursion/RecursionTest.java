package recursion;

import java.util.ArrayList;

public class RecursionTest {

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int nextInt) {
        return null;
    }

    public static String reverseStringRecursion(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverseStringRecursion(s.substring(1)) + s.charAt(0);
    }

    public static boolean checkPalindromeRecursion(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return checkPalindromeRecursion(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public static String decimalToBinaryRecursion(int decimal) {
        String result = "";
        result = decimalToBinaryRecursion(decimal, result);
        return result;
    }

    private static String decimalToBinaryRecursion(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }
        result = decimal % 2 + result;
        return decimalToBinaryRecursion(decimal / 2, result);
    }

    public static int sumOfNumbersRecursion(int n) {
        if (n <= 1)
            return n;
        return n + sumOfNumbersRecursion(n - 1);
    }

    public static int binarySearchRecursion(int[] arr, int element) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;

        return binarySearchRecursion(arr, left, right, mid, element);
    }

    private static int binarySearchRecursion(int[] arr, int left, int right, int mid, int element) {
        if (left > right) {
            return -1;
        }
        if (element == arr[mid]) {
            return mid;
        }
        if (element < arr[mid]) {
            right = mid - 1;
            mid = (left + right) / 2;
            return binarySearchRecursion(arr, left, right, mid, element);
        } else {
            left = mid + 1;
            mid = (left + right) / 2;
            return binarySearchRecursion(arr, left, right, mid, element);
        }
    }

}
