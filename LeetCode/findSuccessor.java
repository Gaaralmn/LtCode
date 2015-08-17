class TreeNode {
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

public class findSuccessor {
	public static TreeNode findSuc(TreeNode node) {
		if (node.right != null)
			return findMin(node.right);
		if (node.parent != null) {
			TreeNode parent = node.parent;
			while (p != null && n == parent.right) {
				node = parent;
				parent = parent.parent;
			}
			
		}
		return node;
	}

	public static TreeNode findMin(TreeNode node) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
}