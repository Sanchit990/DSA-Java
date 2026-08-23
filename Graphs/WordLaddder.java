package Graphs;
import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     Set<String> h = new HashSet<>();

for(String word : wordList) {
    h.add(word);
}

if(!h.contains(endWord)) {
    return 0;
}

Queue<String> q = new LinkedList<>();
q.offer(beginWord);

int level = 1;

while(!q.isEmpty()) {

    int size = q.size();

    for(int i = 0; i < size; i++) {

        String word = q.poll();

        if(word.equals(endWord)) {
            return level;
        }

        char[] chars = word.toCharArray();
        int n=chars.length;
        for(int j = 0; j < n; j++) {

            char original = chars[j];

            for(char c = 'a'; c <= 'z'; c++) {

                chars[j] = c;

                String newWord = new String(chars);

                if(h.contains(newWord)) {
                    q.offer(newWord);
                    h.remove(newWord);
                }
            }

            chars[j] = original;
        }
    }

    level++;
}

return 0;
    }
}
