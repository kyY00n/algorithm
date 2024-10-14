package boj;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode_1249 {

    class Element {
        int index;
        char bracket;

        public Element(int index, char bracket) {
            this.index = index;
            this.bracket = bracket;
        }

        public boolean isOpen() {
            return bracket == '(';
        }
    }

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Element> stack = new Stack<>();
        Set<Integer> toBeRemoved = new HashSet<>();

        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(new Element(i, '('));
                continue;
            }
            if (chars[i] == ')') {
                if (!stack.isEmpty() && stack.peek().isOpen()) {
                    stack.pop();
                    continue;
                }
                toBeRemoved.add(i);
            }
        }

        while(!stack.isEmpty()) {
            toBeRemoved.add(stack.pop().index);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if (toBeRemoved.contains(i)) {
                continue;
            }
            sb.append(chars[i]);
        }

        return sb.toString();

    }

}
