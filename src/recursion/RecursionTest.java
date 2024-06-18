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

}
