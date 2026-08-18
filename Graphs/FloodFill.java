package Graphs;
import java.util.*;
class Solution {
    class pair{
        int a ; int b ;
        pair(int a , int b ){
            this.a=a;
            this.b=b;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(sr,sc));
        int ori=image[sr][sc];
        if(image[sr][sc]==color){
            return image;
        }
        if(image[sr][sc]!=color){
        image[sr][sc]=color;
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                pair obj = q.poll();
               int a=obj.a;
               int b= obj.b;
               if(a+1<image.length&&image[a+1][b]==ori){
                image[a+1][b]=color;
                q.offer(new pair(a+1,b));
               }
               if(a-1>=0&&image[a-1][b]==ori){
                image[a-1][b]=color;
                q.offer(new pair(a-1,b));
               }
               if(b+1<image[0].length&&image[a][b+1]==ori){
                image[a][b+1]=color;
                q.offer(new pair(a,b+1));
               }
               if(b-1>=0&&image[a][b-1]==ori){
                image[a][b-1]=color;
                q.offer(new pair(a,b-1));
               }
            }
        }
        return image;
    }
}