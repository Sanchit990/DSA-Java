package BinarySearchTrees;
import java.util.ArrayList;
import java.util.List;
public class TwoSum4 {
    List<Integer> a = new ArrayList<>();
    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        a.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {

        a.clear();
        inorder(root);

        int i = 0;
        int r = a.size() - 1;

        while (i < r) {

            int sum = a.get(i) + a.get(r);

            if (sum == k) {
                return true;
            }
            else if (sum > k) {
                r--;
            }
            else {
                i++;
            }
        }

        return false;
    }
}