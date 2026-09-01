package Graphs;
import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>>a=new ArrayList<>();
        int n =graph.length;
        int []indegree=new int[n];
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){

            for (int j:graph[i]){
                a.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        int []temp=new int[n];
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int b =q.poll();
            temp[b]= -1;
            for(Integer i:a.get(b)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(temp[i]==-1)
            ans.add(i);
        }
        return ans;
    }
}