package Graphs;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedwithSameRoworColumn {
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
    public int removeStones(int[][] stones) {
        int n=stones.length;
     for(int i=0;i<n;i++){
        parent.add(i);
        size.add(1);
     }   
     int count=0;
     for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    if(!findUnionBysize(i, j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
