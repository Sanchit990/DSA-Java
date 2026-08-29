package Graphs;
import java.util.*;
class Solution {
    List<Integer>ans=new ArrayList<>();
    private boolean dfs(int node,int []state, List<List<Integer>>a){
        if(state[node]==1){
            return false;
        }
        if(state[node]==2){
            return true;
        }
        state[node]=1;
        for(Integer i:a.get(node)){
                 if(!dfs(i,state,a)){
                    return false;
        }
        }
            state[node]=2;
            ans.add(node);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;      
        int state[]=new int[n];
        Arrays.fill(state,0);
        List<List<Integer>>a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int []i:prerequisites){
          a.get(i[1]).add(i[0]);  
        }
        for(int i=0;i<n;i++){
            if(state[i]==0){
                if(!dfs(i,state,a)){
                    return new int[]{};
                }
            }
        }
        int[] ans1=new int[ans.size()];
        for(int i=ans.size()-1;i>=0;i--){
            ans1[n-i-1]=ans.get(i);
        }
        return ans1;
    }
}