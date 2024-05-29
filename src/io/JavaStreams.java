package io;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    static FastWriter fastWriter = new FastWriter();

    public static void main(String[] args) throws IOException {
        try {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            calculateSum(numbers);
            filterEvenNumbers();
            convertToUpperCase();
            findMaxElementInList();
            findWordsStartWithCharacter();
            makeASingleList();
            groupStringByLength();
            divideIntoEvenAndOdd();
            findFirstNonRepeatingCharacter();
            listOfSquares();
            concatenateStrings();
            calculateAverage();
            findLongestStringInList();
            removeDuplicatesFromList();
            findCommonElementsInLists();
            mergeTwoLists();
        } finally {
            fastWriter.flush();
            fastWriter.close();
        }
    }

    // Problem 15: Merge Two Lists
    // Task: Given two lists of integers, merge them into a single list while
    // preserving the order of elements.
    private static void mergeTwoLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> mergedIntegers = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println(mergedIntegers);
    }

    // Problem 14: Find Common Elements in Two Lists
    // Task: Given two lists of integers, find the common elements between them.
    private static void findCommonElementsInLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> commonList = list1.stream().filter(number -> list2.contains(number)).toList();
        System.out.println(commonList);
    }

    // Problem 13: Remove Duplicates from a List
    // Task: Given a list of integers, remove duplicates and retain only the unique
    // elements.
    private static void removeDuplicatesFromList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3);
        List<Integer> uniqueList = numbers.stream().distinct().toList();
        System.out.println(uniqueList);
    }

    // Problem 12: Find the Longest String
    // Task: Given a list of strings, find the longest string.
    private static void findLongestStringInList() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "durian", "grape");

        String longestString = strings.stream().collect(Collectors.maxBy((x, y) -> x.length() - y.length())).get();
        System.out.println(longestString);
    }

    // Problem 11: Calculate the Average of Integers
    // Task: Given a list of integers, calculate the average value.
    private static void calculateAverage() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue)).intValue();
        System.out.println(average);
    }

    // Problem 10: Concatenate Strings with a Separator
    // Task: Given a list of strings, concatenate them into a single string with a
    // specified separator between each original string.
    private static void concatenateStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        String separator = ", ";
        String resultString = strings.stream().collect(Collectors.joining(separator));
        System.out.println(resultString);
    }

    // Problem 10: Create a List of Squares
    // Task: Given a list of integers, create a new list containing the squares of
    // each integer.
    private static void listOfSquares() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareIntegers = numbers.stream().map(num -> num * num).toList();
        System.out.println(squareIntegers);
    }

    // Problem 9: Find the First Non-Repeated Character
    // Task: Given a string, find the first character that does not repeat.
    private static void findFirstNonRepeatingCharacter() {
        String text = "swiss";

        Map<Character, Long> countmap = text.chars().mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char resultCharacter = text.chars().mapToObj(character -> (char) character)
                .filter(character -> countmap.get(character) == 1).findFirst().get();

        System.out.println(resultCharacter);

    }

    // Problem 8: Partitioning by Predicate
    // Task: Given a list of integers, partition them into two groups: even and odd.
    private static void divideIntoEvenAndOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, List<Integer>> partitionMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 2 == 0 ? "even" : "odd"));
        System.out.println(partitionMap);
    }

    // Problem 7: Group Strings by Length
    // Task: Given a list of strings, group them by their length.
    private static void groupStringByLength() throws IOException {
        List<String> strings = Arrays.asList("apple", "bat", "cat", "doll", "elephant");
        Map<Integer, List<String>> countMap = strings.stream()
                .collect(Collectors.groupingBy(object -> object.length()));

        System.out.println(countMap);

    }

    // Problem 6: Flatten a List of Lists
    // Task: Given a list of lists of integers, flatten it into a single list.
    private static void makeASingleList() throws IOException {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5));

        List<Integer> flatList = listOfLists.stream().flatMap(list -> list.stream()).toList();
        fastWriter.writeList(flatList);
    }

    // Problem 5: Count Words Starting with a Letter
    // Task: Given a list of strings and a character, count how many strings start
    // with that character.
    private static void findWordsStartWithCharacter() throws IOException {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "cherry");
        char letter = 'a';
        int countWords = (int) words.stream().filter(fruit -> fruit.startsWith(Character.toString(letter))).count();
        fastWriter.writeLine(countWords);
    }

    // Problem 4: Find the Maximum Number
    // Task: Given a list of integers, find the maximum value.
    private static void findMaxElementInList() throws IOException {
        List<Integer> numbers = Arrays.asList(3, 8, 1, 6, 4);
        int maxInteger = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        fastWriter.writeLine(maxInteger);
    }

    // Problem 3: Convert Strings to Uppercase
    // Task: Given a list of strings, convert each string to uppercase.
    private static void convertToUpperCase() throws IOException {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<String> upperCaseStrings = strings.stream().map(fruit -> fruit.toUpperCase()).toList();
        fastWriter.writeList(upperCaseStrings);
    }

    // Problem 2: Filter Even Numbers
    // Task: Given a list of integers, filter out all the even numbers.
    private static void filterEvenNumbers() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).toList();
        fastWriter.writeList(evenNumbers);
    }

    // Problem 1: Sum of Integers
    // Task: Given a list of integers, find the sum of all elements using streams.
    private static void calculateSum(List<Integer> numbers) throws IOException {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        fastWriter.writeLine(sum);
    }

}
