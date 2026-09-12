package Graphs;
import java.util.*;
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    class pair {
        int node;
        int w;
        pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<pair>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            a.get(u).add(new pair(v, w));
            a.get(v).add(new pair(u, w));
        }
        int ans = -1;
        int minCount = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[i] = 0;
            PriorityQueue<pair> pq =new PriorityQueue<>((x, y) -> x.w - y.w);
            pq.add(new pair(i, 0));
          while (!pq.isEmpty()) {
                pair obj=pq.poll();
                int node=obj.node;
                int dist=obj.w;
                if (dist>dis[node]) {
                    continue;
                }
                for(pair next:a.get(node)) {
                    int newdist = dist+next.w;
                    if(newdist < dis[next.node]) {
                        dis[next.node] = newdist;
                        pq.add(new pair(next.node, newdist));
                 }
            }
            }
            int count = 0;
            for (int k=0;k<n;k++) {
                if (k!=i&&dis[k]<=distanceThreshold) {
                    count++;
                }
            }
            if (count<=minCount) {
                minCount=count;
                ans=i;
            }
        }
        return ans;
    }
}
