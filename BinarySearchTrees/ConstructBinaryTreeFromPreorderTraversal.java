package BinarySearchTrees;
import java.util.*;
public class ConstructBinaryTreeFromPreorderTraversal {
public TreeNode maketree(int []in, int []pre,int instart,int prestart,int inend,int prend,Map<Integer,Integer>m){
        if(instart>inend||prestart>prend){
            return null;
        }
        TreeNode root=new TreeNode(pre[prestart]);
        int inroot=m.get(root.val);
        int left=inroot-instart;
        root.left=maketree(in,pre,instart,prestart+1,inroot-1,prestart+left,m);
        root.right=maketree(in,pre,inroot+1,prestart+left+1,inend,prend,m);
        return root;
    }
    public TreeNode bstFromPreorder(int[] pre) {
        int[]in=new int[pre.length];
        in=pre.clone();
        Arrays.sort(in);
        Map<Integer,Integer>m=new HashMap<>();
         for(int i=0;i<in.length;i++){
            m.put(in[i],i);
        }
        TreeNode root=maketree(in,pre,0,0,in.length-1,pre.length-1,m);
        return root;
    }
}