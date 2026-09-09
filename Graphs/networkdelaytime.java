package Graphs;
import java.util.*;
class Solution {
    class pair{
        int node;
        int w;

        pair(int node, int w){
            this.node=node;
            this.w=w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int ans=0;
        PriorityQueue<pair>q=new PriorityQueue<>((x,y)->x.w-y.w);
        int []dis=new int[n+1];
        List<List<pair>>a=new ArrayList<>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
          a.get(u).add(new pair(v,w));
        }
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        q.offer(new pair(k,0));
        while(!q.isEmpty()){
            pair obj=q.poll();
            int node=obj.node;
            int w=obj.w;
            for(pair i:a.get(node)){
                if(dis[i.node]>w+i.w){
                    dis[i.node]=w+i.w;
                    q.offer(new pair(i.node,w+i.w));
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dis[i]);
        }
        return ans;
    }
}