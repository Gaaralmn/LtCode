/**
 * LeetCode 144 Binary Tree Preorder Traversal.
 * Tag: Stack
 * Follow up: Try recursively! 
 * public class TreeNode {
 */
import java.util.*;
public class preTravBT {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if(node.right != null) {
                s.push(node.right);
            }
            if(node.left != null) {
                s.push(node.left);
            }
        }
        return list;
    }
}