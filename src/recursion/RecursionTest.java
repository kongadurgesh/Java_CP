package recursion;

import java.util.ArrayList;
import java.util.List;
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
            return A % MOD;
        }
        long rPowerNMinus1 = fastExponentiation(R, N - 1, MOD);
        return (int) (A * rPowerNMinus1 % MOD);
    }

    private static long fastExponentiation(int base, int exp, int mod) {
        long result = 1;
        long baseMod = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd, multiply base with result
                result = (result * baseMod) % mod;
            }
            baseMod = (baseMod * baseMod) % mod; // Square the base
            exp >>= 1; // Divide exp by 2
        }

        return result;
    }

    public static List<Integer> printSeries(int n, int k) {
        List<Integer> resultList = new ArrayList<>();
        int temp = n;
        if (n > 0) {
            addDecreasingElementsToList(n, k, resultList);
            n = resultList.get(resultList.size() - 1);
            resultList.remove(resultList.size() - 1);
        }
        if (n <= 0) {
            addIncreasingElementsToList(temp, n, k, resultList);
        }
        return resultList;
    }

    private static void addDecreasingElementsToList(int n, int k, List<Integer> resultList) {
        resultList.add(n);
        if (n > 0) {
            n = n - k;
            addDecreasingElementsToList(n, k, resultList);
        }
        return;
    }

    private static void addIncreasingElementsToList(int temp, int n, int k, List<Integer> resultList) {
        if (n > temp) {
            return;
        }
        resultList.add(n);
        addIncreasingElementsToList(temp, n + k, k, resultList);
    }

    public static ArrayList<ArrayList<Integer>> subsetsOfK(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findSubsets(arr, n, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsets(ArrayList<Integer> arr, int n, int k, int index, ArrayList<Integer> current,
            ArrayList<ArrayList<Integer>> result) {
        // If the sum of the current subset is equal to k, add it to the result
        if (k == 0) {
            result.add(new ArrayList<>(current));
            // Continue searching for other possible subsets
        }

        // If the index is out of bounds, return
        if (index >= n) {
            return;
        }

        // Include the current element in the subset
        current.add(arr.get(index));
        findSubsets(arr, n, k - arr.get(index), index + 1, current, result);

        // Exclude the current element from the subset and backtrack
        current.remove(current.size() - 1);
        findSubsets(arr, n, k, index + 1, current, result);
    }

    public static boolean isItSudoku(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    for (int element = 1; element < 10; element++) {
                        if (isValid(matrix, i, j, element)) {
                            matrix[i][j] = element;

                            if (isItSudoku(matrix))
                                return true;
                            else
                                matrix[i][j] = 0;

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] matrix, int row, int column, int element) {
        for (int i = 0; i < 9; i++) {
            if (matrix[i][column] == element) {
                return false;
            }
            if (matrix[row][i] == element) {
                return false;
            }
            if (matrix[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == element) {
                return false;
            }
        }
        return true;
    }

    public static boolean reachDestination(int sx, int sy, int dx, int dy) {
        if (sx == dx && sy == dy)
            return true;
        if (sx > dx || sy > dy)
            return false;
        return reachDestination(sx + sy, sy, dx, dy) || reachDestination(sx, sy + sx, dx, dy);
    }
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
