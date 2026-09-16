package BinarySearchTrees;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left=null;
        TreeNode right=null;
        if(root==null||root==p||root==q){
            return root;
        }
        if(root.val>p.val||root.val>q.val)
        left=lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val||root.val<q.val)
        right= lowestCommonAncestor(root.right,p,q);
        if(right!=null&&left!=null){
            return root;
        }
        if(right==null&&left!=null){
            return left;
        }
        if(right!=null&&left==null){
            return right;
        }
        else
            return null;
    }
}
