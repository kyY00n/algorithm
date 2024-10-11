package leetcode;

import java.util.Stack;

public class Leetcode_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if (isCloseBracket(chars[i])) {
                // checking operation
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatched(stack.pop(), chars[i])) {
                    return false;
                }
                continue;
            }
            stack.push(chars[i]);
        }

        return stack.isEmpty();
    }

    private boolean isCloseBracket(char bracket) {
        return bracket == ')' || bracket == '}' || bracket == ']';
    }

    private boolean isMatched(char openBracket, char closeBracket) {
        switch(closeBracket) {
            case ')':
                return openBracket == '(';
            case '}':
                return openBracket == '{';
            case ']':
                return openBracket == '[';
            default:
                return false;
        }
    }

}
