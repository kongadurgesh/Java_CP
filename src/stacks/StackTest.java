package stacks;

import java.util.Stack;

public class StackTest {

    public static boolean redundantBrackets(String s) {
        Stack<Character> opStack = new Stack<>();
        boolean operatorPresent = false;
        for (Character character : s.toCharArray()) {
            switch (character) {
                case '+':
                case '-':
                case '*':
                case '/':
                    opStack.push(character);
                    operatorPresent = true;
                    break;
            }
            if (character == '(') {
                if (!opStack.isEmpty() && opStack.peek() == '(') {
                    return true;
                } else {
                    opStack.push(character);
                }
            }
            if (character == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    opStack.pop();
                }
                opStack.pop();
            }
        }
        if (!opStack.isEmpty())
            return true;
        else if (!operatorPresent)
            return true;
        return false;
    }
}
