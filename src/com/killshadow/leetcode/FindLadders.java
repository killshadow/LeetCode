package com.killshadow.leetcode;

import java.util.*;

public class FindLadders {
    public static void main(String[] args) {

    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> ladder = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (isFindEndWorld(current, endWord, wordList, visited, queue)) {
                    res.add(ladder);
                    continue;
                }
            }

        }
        return res;
    }

    public boolean isFindEndWorld(String current, String endWord, List<String> wordList, Set<String> visited, Queue<String> queue) {
        char[] cur = current.toCharArray();
        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < cur.length; j++) {
                if (cur[j] == i) {
                    continue;
                }
                char tmp = cur[j];
                cur[j] = (char) i;
                String nextWord = String.valueOf(cur);
                if (!wordList.contains(nextWord)) {
                    cur[j] = tmp;
                    continue;
                }
                if (nextWord == endWord) {
                    return true;
                }
                queue.offer(String.valueOf(cur));
                visited.add(String.valueOf(cur));

                cur[j] = tmp;
            }
        }
        return false;
    }
}
