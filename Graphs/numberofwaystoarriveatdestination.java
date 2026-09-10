package Graphs;
import java.util.*;
class Solution {
    final int mod=1000000007;
    class pair{
        int node;
        long w;
        pair(int node ,long w){
            this.node=node;
            this.w=w;
        }
    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<pair>q=new PriorityQueue<>((x,y)->Long.compare(x.w,y.w));
        List<List<pair>>a=new ArrayList<>();
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            a.get(u).add(new pair(v,w));
            a.get(v).add(new pair(u,w));
        }
        int ans=0;
        long ways[]=new long[n];
        ways[0]=1;
        q.offer(new pair(0,0));
        while(!q.isEmpty()){
            pair obj=q.poll();
            int node=obj.node;
            long dis=obj.w;
            for(pair i:a.get(node)){
            if(i.w+dis<dist[i.node]){
                dist[i.node]=i.w+dis;
                ways[i.node]=ways[node];
                q.offer(new pair(i.node,i.w+dis));
            }
            else if(dis+i.w==dist[i.node])
             ways[i.node]=(ways[i.node]+ways[node])%mod;
            }
        }
        return (int) ways[n-1];
    }
}