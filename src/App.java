import java.io.IOException;

import arrays.ArraysTest;
import io.FastReader;
import io.FastWriter;
import linkedlists.LinkedListTest;
import linkedlists.Node;
import stacks.StackTest;
import strings.StringsTest;

public class App {

    private static FastReader reader;

    private static FastWriter writer;

    public static void main(String[] args) throws Exception {
        setUp();

        int question = 8;
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
            default:
                break;
        }
    }

    private static void redundantBrackets() throws IOException {
        int t = reader.nextInt();
        while (t-- > 0) {
            String testString = reader.readLine();
            boolean valid = StackTest.redundantBrackets(testString);
            writer.write(valid);
            writer.writeLine("");
            writer.flush();
        }
    }

    private static void reverseLinkedList() throws IOException {
        String[] dataStrings = reader.readLine().split(" ");
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
        String[] dataStrings = reader.readLine().split(" ");
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
            String[] nums = reader.readLine().split(" ");
            String sumString = StringsTest.addStrings(nums[0], nums[1]);
            writer.writeLine(sumString);
            writer.flush();
        }
    }

    private static void convertString() throws IOException {
        int t = reader.nextInt();
        while (t-- > 0) {
            String testString = reader.readLine();
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

    private static void setUp() {
        reader = new FastReader();
        writer = new FastWriter();
    }
}