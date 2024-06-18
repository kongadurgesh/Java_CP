package recursion;

import java.util.ArrayList;

import linkedlists.Node;

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

    public static int FibonacciNumbersRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return FibonacciNumbersRecursion(n - 1) + FibonacciNumbersRecursion(n - 2);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

    public static Node reverseLinkedListRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverseLinkedListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static Node mergeLinkedLists(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data < b.data) {
            a.next = mergeLinkedLists(a.next, b);
            return a;
        } else {
            b.next = mergeLinkedLists(a, b.next);
            return b;
        }
    }

}
