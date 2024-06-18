package stacks;

import java.util.Stack;

public class StackTest {

    public static boolean redundantBrackets(String s) {
        Stack<Character> opStack = new Stack<>();
        for (Character character : s.toCharArray()) {
            switch (character) {
                case '+':
                case '-':
                case '*':
                case '/':
                    opStack.push(character);
                    break;
            }
            if (character == '(') {
                opStack.push(character);
            }
            if (character == ')') {
                if (opStack.peek() == '(') {
                    return true;
                }
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    opStack.pop();
                }
                opStack.pop();
            }
            System.out.println(opStack.toString());
        }
        return false;
    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> opStack = new Stack<>();
        for (Character character : s.toCharArray()) {
            switch (character) {
                case '[':
                case '{':
                case '(':
                    opStack.push(character);
                    break;
            }
            if (character == ')') {
                if (opStack.isEmpty())
                    return false;
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    opStack.pop();
                }
                if (!opStack.isEmpty()) {
                    opStack.pop();
                }
            }
            if (character == ']') {
                if (opStack.isEmpty())
                    return false;
                while (!opStack.isEmpty() && opStack.peek() != '[') {
                    opStack.pop();
                }
                if (!opStack.isEmpty()) {
                    opStack.pop();
                }
            }
            if (character == '}') {
                if (opStack.isEmpty())
                    return false;
                while (!opStack.isEmpty() && opStack.peek() != '{') {
                    opStack.pop();
                }
                if (!opStack.isEmpty()) {
                    opStack.pop();
                }

            }
        }
        return opStack.isEmpty();
    }
}
