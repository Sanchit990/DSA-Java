package Graphs;
import java.util.*;

class Solution {

   class helper {
        int node;
        int dist;
        int k;

        helper(int node, int dist, int k) {
            this.node = node;
            this.dist = dist;
            this.k = k;
        }
    }

public int findCheapestPrice(int n, int[][] flights,int src, int dst, int k) {
    int max = k + 1;
    PriorityQueue<helper>q=new PriorityQueue<>((x, y) -> x.dist - y.dist);List<List<helper>>a=new ArrayList<>();
    for (int i = 0; i < n; i++) {
         a.add(new ArrayList<>());
         }
    for (int i = 0; i < flights.length; i++) {
        int u = flights[i][0];
        int v = flights[i][1];
        int weight = flights[i][2];
        a.get(u).add(new helper(v, weight, 0));
        }
        int[][] dist = new int[n][max + 1];// dist[node][number of flights used]
    for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
    dist[src][0] = 0;
    q.offer(new helper(src, 0, 0));
    while (!q.isEmpty()) {
        helper obj = q.poll();
        int node = obj.node;
        int cost = obj.dist;
        int count = obj.k;
        if (node == dst) {
            return cost;
        }
        if (count == max) {
             continue;
        }
        for (helper x : a.get(node)) {
            int neighbour = x.node;
            int price = x.dist;
            int newCost = cost + price;
            int newCount = count + 1;
            if (newCost < dist[neighbour][newCount]) {
                dist[neighbour][newCount] = newCost;
                q.offer(new helper(neighbour,newCost,newCount));
            }
        }
        }
    return -1;
    }
}