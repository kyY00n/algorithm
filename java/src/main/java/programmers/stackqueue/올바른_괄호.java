package programmers.stackqueue;

import java.util.Stack;

public class 올바른_괄호 {

    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for(int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') { // if current character is closing bracket
                // check if the top element of the stack is opening bracket
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                continue;
            }
            stack.push(chars[i]);
        }
        return stack.isEmpty();
    }

}
