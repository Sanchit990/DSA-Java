package Graphs;
import java.util.*;
public class NumberofOperationstoMakeNetworkConnected {
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    public int findUltimateparent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ult=findUltimateparent(parent.get(node));
        parent.set(node,ult);
        return parent.get(node);
    }
    public boolean findUnionBysize(int u,int v){
        int uu=findUltimateparent(u);
        int uv=findUltimateparent(v);
        if(uu==uv){
            return true;
        }
        else if(size.get(uu)<size.get(uv)){
            parent.set(uu,uv);
            size.set(uv,size.get(uu)+size.get(uv));
        }
        else{
            parent.set(uv,uu);
            size.set(uu,size.get(uu)+size.get(uv));
        }
        return false;
    }
    public int makeConnected(int n, int[][] connections) {
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
        int count=n;
        if(connections.length<n-1){
            return -1;
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
                boolean con=findUnionBysize(u,v);
            if(!con){
                count--;
            }
        }
        return count-1;
    }
}
