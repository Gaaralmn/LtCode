/**
 * LeetCode 104
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class maxDepth {
    public int maxDepth0(TreeNode root) {
        if(root == null)
            return 0;
        int h = 0;
        h = Math.max(h, Math.max(maxDepth0(root.left), maxDepth0(root.right)));
        return h + 1;
    }
    
    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        return getDepth(root, 1);
    }
    
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
            
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int count = 0;
        
        while(!list.isEmpty()) {
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            for(TreeNode node : list) {
                if(node.left != null) 
                    newlist.add(node.left);
                if(node.right != null)
                    newlist.add(node.right);
            }
            count++;
            list = new LinkedList<TreeNode>(newlist);
        }
        return count;
    }
    
    public int getDepth(TreeNode node, int depth) {
        int left = depth;
        int right = depth;
        if(node.left != null)
            left = getDepth(node.left, depth + 1);
        if(node.right != null)
            right = getDepth(node.right, depth + 1);
        return left > right ? left : right;
    }
    
}