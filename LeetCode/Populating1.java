/**
 * tags: Deserve to reconsider for the corner cases
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    public TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Populating1 {
    //Method with while loop
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode parent = root;
        TreeLinkNode pre;
        TreeLinkNode next;
        while (parent != null) {
            pre = null;
            next = parent.left;// What if there is only one Node here?
            while (parent != null) {
                if (pre == null) {
                    pre = parent.left;
                } else {
                    pre.next = parent.left;
                    pre = pre.next;
                }
                pre.next = parent.right;
                pre = pre.next;
                parent = parent.next;
            }
            parent = next;
        }
    }
    //Method with recursion
    public void connect(TreeLinkNode root) {
        if (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null) {
                root.right.next = root.next != 0 ? root.next.left : null;
            }
            connect(root.left);
            connect(root.right);
        }

    }
}
