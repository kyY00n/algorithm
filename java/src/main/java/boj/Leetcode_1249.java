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

    class EnhancedSolution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            Set<Integer> invalidIndices = new HashSet<>();

            // First pass: mark invalid parentheses
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        invalidIndices.add(i);  // unmatched closing parenthesis
                    }
                }
            }

            // Add any unmatched opening parentheses to the set of invalid indices
            while (!stack.isEmpty()) {
                invalidIndices.add(stack.pop());
            }

            // Second pass: build the result string by skipping invalid indices
            for (int i = 0; i < s.length(); i++) {
                if (!invalidIndices.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString();
        }
    }


}
