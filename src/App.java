import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import arrays.ArraysTest;
import io.FastReader;
import io.FastWriter;
import linkedlists.LinkedListTest;
import linkedlists.Node;
import queues.Deque;
import recursion.RecursionTest;
import stacks.StackTest;
import strings.StringsTest;
import trees.TreeNode;
import trees.TreesTest;

public class App {

    private static FastReader reader;

    private static FastWriter writer;

    public static void main(String[] args) throws Exception {
        setUp();

        int question = 22;
        switch (question) {
            case 1:
                linearSearch();
                break;
            case 2:
                arraySum();
                break;
            case 3:
                largestElement();
                break;
            case 4:
                convertString();
                break;
            case 5:
                addStrings();
                break;
            case 6:
                linkedListSearch();
                break;
            case 7:
                reverseLinkedList();
                break;
            case 8:
                redundantBrackets();
                break;
            case 9:
                isValidParenthesis();
                break;
            case 10:
                implementDeque();
                break;
            case 11:
                towerOfHanoi();
                break;
            case 12:
                reverseStringRecursion();
                break;
            case 13:
                checkPalindromeRecursion();
                break;
            case 14:
                decimalToBinaryRecursion();
                break;
            case 15:
                binarySearchRecursion();
                break;
            case 16:
                sumOfNumbersRecursion();
                break;
            case 17:
                sumOfFibonacciNumbersRecursion();
                break;
            case 18:
                mergeSort();
                break;
            case 19:
                reverseLinkedListRecursion();
                break;
            case 20:
                mergeLinkedLists();
                break;
            case 21:
                addNodeToTree();
                break;
            case 22:
                printAllLeafNodes();
                break;
            default:
                break;
        }
    }

    private static void printAllLeafNodes() {
        TreeNode head = null;
        int[] arr = Arrays.stream(reader.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : arr) {
            head = TreesTest.addNodeToTree(head, i);
        }
        ArrayList<Integer> inOrderList = TreesTest.printAllLeafNodes(head, new ArrayList<>());
        for (Integer item : inOrderList) {
            writer.writeLine(item);
        }
        writer.flush();
    }

    private static void addNodeToTree() {
        TreeNode head = null;
        int[] arr = Arrays.stream(reader.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : arr) {
            head = TreesTest.addNodeToTree(head, i);
        }
        ArrayList<Integer> inOrderList = TreesTest.inOrderTraversal(head, new ArrayList<>());
        for (Integer item : inOrderList) {
            writer.writeLine(item);
        }
        writer.flush();
    }

    private static void mergeLinkedLists() {
        String[] dataStrings = reader.nextLine().split(" ");
        Node A = new Node(Integer.parseInt(dataStrings[0]));
        Node tempNode = A;
        for (int i = 1; i < dataStrings.length; i++) {
            tempNode.setNext(new Node(Integer.parseInt(dataStrings[i])));
            tempNode = tempNode.getNext();
        }
        dataStrings = reader.nextLine().split(" ");
        Node B = new Node(Integer.parseInt(dataStrings[0]));
        tempNode = B;
        for (int i = 1; i < dataStrings.length; i++) {
            tempNode.setNext(new Node(Integer.parseInt(dataStrings[i])));
            tempNode = tempNode.getNext();
        }
        Node mergedNode = RecursionTest.mergeLinkedLists(A, B);
        while (mergedNode != null) {
            writer.writeLine(mergedNode.data);
            mergedNode = mergedNode.next;
        }
        writer.flush();
    }

    private static void reverseLinkedListRecursion() {
        String[] dataStrings = reader.nextLine().split(" ");
        Node head = new Node(Integer.parseInt(dataStrings[0]));
        Node tempNode = head;
        for (int i = 1; i < dataStrings.length; i++) {
            tempNode.setNext(new Node(Integer.parseInt(dataStrings[i])));
            tempNode = tempNode.getNext();
        }
        Node reverseHead = RecursionTest.reverseLinkedListRecursion(head);
        while (reverseHead != null) {
            writer.writeLine(reverseHead.data);
            reverseHead = reverseHead.next;
        }
        writer.flush();
    }

    private static void mergeSort() {
        int[] arr = Arrays.stream(reader.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        RecursionTest.mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            writer.writeLine(i);
        }
        writer.flush();
    }

    private static void sumOfFibonacciNumbersRecursion() throws IOException {
        int n = reader.nextInt();
        int sum = RecursionTest.FibonacciNumbersRecursion(n);
        printResult(sum);
    }

    private static void sumOfNumbersRecursion() throws IOException {
        int n = reader.nextInt();
        int sum = RecursionTest.sumOfNumbersRecursion(n);
        printResult(sum);
    }

    private static void binarySearchRecursion() throws IOException {
        int[] arr = Arrays.stream(reader.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = RecursionTest.binarySearchRecursion(arr, reader.nextInt());
        printResult(index);
    }

    private static void decimalToBinaryRecursion() throws IOException {
        int decimal = reader.nextInt();
        String binary = RecursionTest.decimalToBinaryRecursion(decimal);
        printResult(binary);
    }

    private static void checkPalindromeRecursion() throws IOException {
        String s = reader.nextLine();

        boolean isPalindrome = RecursionTest.checkPalindromeRecursion(s);
        writer.write(isPalindrome);
        writer.flush();
    }

    private static void reverseStringRecursion() throws IOException {
        String s = reader.nextLine();

        String reverseString = RecursionTest.reverseStringRecursion(s);
        printResult(reverseString);
    }

    private static void towerOfHanoi() throws IOException {
        ArrayList<ArrayList<Integer>> resultList = RecursionTest.towerOfHanoi(reader.nextInt());
        for (ArrayList<Integer> move : resultList) {
            System.out.println("Move disk from rod " + move.get(0) + " to rod " + move.get(1));
        }
    }

    private static void implementDeque() throws IOException {
        int[] sizeOp = Arrays.stream(reader.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque deque = new Deque(sizeOp[0]);
        int operations = sizeOp[1];
        while (operations-- > 0) {
            int[] line = Arrays.stream(reader.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (line[0]) {
                case 1:
                    writer.write(deque.pushFront(line[1]));
                    writer.writeLine("");
                    break;
                case 2:
                    writer.write(deque.pushRear(line[1]));
                    writer.writeLine("");
                    break;
                case 3:
                    writer.write(deque.popFront());
                    writer.writeLine("");
                    break;
                case 4:
                    writer.write(deque.popRear());
                    writer.writeLine("");
                    break;
                case 5:
                    writer.write(deque.getFront());
                    writer.writeLine("");
                    break;
                case 6:
                    writer.write(deque.getRear());
                    writer.writeLine("");
                    break;
                case 7:
                    writer.write(deque.isEmpty());
                    writer.writeLine("");
                    break;
                case 8:
                    writer.write(deque.isFull());
                    writer.writeLine("");
                    break;
                default:
                    break;
            }
        }
        writer.flush();
    }

    private static void isValidParenthesis() throws IOException {
        String s = reader.nextLine();
        boolean valid = StackTest.isValidParenthesis(s);
        if (valid) {
            printResult("Balanced");
        } else {
            printResult("Not Balanced");
        }
    }

    private static void redundantBrackets() throws IOException {
        int t = reader.nextInt();
        while (t-- > 0) {
            String testString = reader.nextLine();
            boolean valid = StackTest.redundantBrackets(testString);
            writer.write(valid);
            writer.writeLine("");
            writer.flush();
        }
    }

    private static void reverseLinkedList() throws IOException {
        String[] dataStrings = reader.nextLine().split(" ");
        Node head = new Node(Integer.parseInt(dataStrings[0]));
        Node tempNode = head;
        for (int i = 1; i < dataStrings.length - 1; i++) {
            tempNode.setNext(new Node(Integer.parseInt(dataStrings[i])));
            tempNode = tempNode.getNext();
        }
        Node reverseHead = LinkedListTest.reverseLinkedList(head);
        while (reverseHead != null) {
            writer.writeLine(reverseHead.data);
            reverseHead = reverseHead.next;
        }
        writer.flush();
    }

    private static void linkedListSearch() throws IOException {
        String[] dataStrings = reader.nextLine().split(" ");
        Node headNode = new Node(Integer.parseInt(dataStrings[0]));
        Node tempNode = headNode;
        for (int i = 1; i < dataStrings.length - 1; i++) {
            tempNode.setNext(new Node(Integer.parseInt(dataStrings[i])));
            tempNode = tempNode.getNext();
        }
        Node middleNode = LinkedListTest.findMiddle(headNode);
        while (middleNode != null) {
            writer.writeLine(middleNode.getData());
            middleNode = middleNode.getNext();
        }
        writer.flush();
    }

    private static void addStrings() throws IOException {
        int t = reader.nextInt();
        while (t-- > 0) {
            String[] nums = reader.nextLine().split(" ");
            String sumString = StringsTest.addStrings(nums[0], nums[1]);
            writer.writeLine(sumString);
            writer.flush();
        }
    }

    private static void convertString() throws IOException {
        int t = reader.nextInt();
        while (t-- > 0) {
            String testString = reader.nextLine();
            String convertedString = StringsTest.convertString(testString);
            printResult(convertedString);
        }
    }

    private static void largestElement() throws IOException {
        int n = reader.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        int maxElement = ArraysTest.findLargest(arr, n);
        printResult(maxElement);
    }

    private static void printResult(int element) throws IOException {
        writer.writeLine(element);
        writer.flush();
    }

    private static void printResult(String element) throws IOException {
        writer.writeLine(element);
        writer.flush();
    }

    private static void arraySum() throws IOException {
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        int sum = ArraysTest.arraysSum(arr, n);
        writer.write(sum);
        writer.flush();
    }

    private static void linearSearch() throws IOException {
        int n = reader.nextInt();
        int num = reader.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        int index = ArraysTest.linearSearch(n, num, arr);
        writer.write(index);
        writer.flush();
    }

    private static void setUp() throws IOException {
        reader = new FastReader();
        writer = new FastWriter();
    }
}