package recursion;

import java.util.ArrayList;

import linkedlists.Node;

public class RecursionTest {

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        solveHanoi(n, 1, 3, 2, resultList);
        return resultList;
    }

    private static void solveHanoi(int n, int source, int destination, int via,
            ArrayList<ArrayList<Integer>> resultList) {
        if (n == 1) {
            ArrayList<Integer> move = new ArrayList<>();
            move.add(source);
            move.add(destination);
            resultList.add(move);
            return;
        }
        solveHanoi(n - 1, source, via, destination, resultList);
        ArrayList<Integer> move = new ArrayList<>();
        move.add(source);
        move.add(destination);
        resultList.add(move);
        solveHanoi(n - 1, via, destination, source, resultList);
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

    public static String familyStructureRecursion(int n, int k) {
        FamilyNode familyNode = createFamily(n);
        ArrayList<String> nThGeneration = new ArrayList<>();
        nThGeneration = getAllChildren(familyNode, nThGeneration);
        return nThGeneration.get(k - 1);
    }

    private static ArrayList<String> getAllChildren(FamilyNode familyNode, ArrayList<String> arrayList) {
        FamilyNode temp = familyNode;
        if (temp == null) {
            return arrayList;
        }
        if (temp.left == null && temp.right == null) {
            arrayList.add(temp.gender);
        }
        if (temp.left != null) {
            getAllChildren(temp.left, arrayList);
        }
        if (temp.right != null) {
            getAllChildren(temp.right, arrayList);
        }
        return arrayList;
    }

    private static FamilyNode createFamily(int levels) {
        return familyCreator(1, levels, "Male");

    }

    private static FamilyNode familyCreator(int currentLevel, int maxLevel, String parentGender) {
        if (currentLevel > maxLevel) {
            return null;
        }
        String currentGender = parentGender.equals("Male") ? "Male" : "Female";
        FamilyNode familyNode = new FamilyNode(currentLevel, currentGender);

        String leftGender = currentGender.equals("Male") ? "Male" : "Female";
        String rightGender = currentGender.equals("Male") ? "Female" : "Male";

        familyNode.left = familyCreator(currentLevel + 1, maxLevel, leftGender);
        familyNode.right = familyCreator(currentLevel + 1, maxLevel, rightGender);

        return familyNode;
    }

    public static int nthTermOfGP(int N, int A, int R) {
        final int MOD = 1_000_000_007;
        if (N == 0) {
            return 0;
        }
        return nthTermOfGPRecursive(N, A, R, 1, MOD) % MOD;
    }

    private static int nthTermOfGPRecursive(int N, int A, int R, int currentPowerOfR, int MOD) {
        if (N == 1) {
            return A % MOD;
        }
        int nextPowerOfR = multiplyMod(currentPowerOfR, R);
        return multiplyMod(A, nthTermOfGPRecursive(N - 1, 1, R, nextPowerOfR, MOD));
    }

    private static int multiplyMod(int a, int b) {
        return (int) (((long) a * b) % 1_000_000_007);
    }

    /**
     * FamilyNode
     */

}

class FamilyNode {
    public int value;
    public String gender;
    public FamilyNode left;
    public FamilyNode right;

    public FamilyNode(int value, String gender) {
        this.value = value;
        this.gender = gender;
    }

}
