/**
 * Node that might be used to build a tree. 
 */
public class TreeNode {
	public int val;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;


	public TreeNode(int val) {
		this.val = val;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
}