package leetcode;

import java.util.Collections;
import java.util.List;

class Leetcode_648 {

    Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (s1, s2) -> s1.length() - s2.length());
        sentence = " " + sentence;
        for (String root : dictionary) {
            String withSpace = " " + root;
            String regex = String.format("%s\\w*", withSpace);
            sentence = sentence.replaceAll(regex, withSpace);
        }
        if (sentence.charAt(0) == ' ') {
            return sentence.substring(1);
        }
        return sentence;
    }

    public String improvedReplaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] input = sentence.split(" ");
        for (String i : input) {
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }

    public String search(String word) {
        Trie node = root;
        int j = 0;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            j++;
            if (node.children[i] == null) {
                return word;
            } else if (node.children[i].isEnd) {
                return word.substring(0, j);
            } else {
                node = node.children[i];
            }

        }
        return word;

    }

    public void insert(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

}

class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

}
