package Graphs;

import java.util.*;

public class MaximumNumberofNon {
    public List<String> maxNumOfSubstrings(String s) {
        int[] count = new int[26];
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (count[c] == 0) {
                first[c] = i;
                order.add(c);
            }

            count[c]++;
            last[c] = i;
        }

        List<String> res = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i : order) {
            queue.addFirst(new int[]{
                first[i], last[i], count[i]
            });

            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            int total = 0;

            for (int[] item : queue) {
                total += item[2];
                left = Math.min(left, item[0]);
                right = Math.max(right, item[1]);

                if (total == right - left + 1) {
                    break;
                }
            }

            if (total == right - left + 1) {
                res.add(s.substring(left, right + 1));
                queue.clear();
            }
        }

        return res;
    }
}
