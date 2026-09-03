package Graphs
import java.util.*;


public class shortestpathindirectedacyclicgraph {
    class pair{
        int node;
        int w;
        pair(int node , int weight){
            this.node=node;
            this.w=weight;
        }
    }

    int[]shortestPath(int V, int E, int[][]edges){
        List<List<Integer>>a=new ArrayList<>();

        for(int i=0;i<V;i++){
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
        
            a.get(u).add(new pair(v, weight));
        }

    Queue<Integer>q=new LinkedList<>();
    q.offer(0);
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[0] = 0;
 
    while(!q.isEmpty()){
        int node=q.poll();
        for(pair i:a.get(node)){
            int neighbournode=i.node;
            int neighbourweight=i.w;
            if(dist[node]+neighbourweight<=dist[neighbournode]){
                dist[neighbournode]=dist[node]+neighbourweight;
                q.offer(neighbournode);
            }
        }
    }
    for(int i=0;i<V;i++){
        if(dist[i]==Integer.MAX_VALUE){
            dist[i]=-1;
        }
    }
    return dist;
}
    
}