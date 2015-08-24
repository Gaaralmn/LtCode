import java.util.*;
class Node {
    public int val;
    public Node[] Children;
    public Node Right;

    public Node(int val, Node[] Children) {
        this.val = val;
        this.Children = Children;
        this.Right = null;
    }
}

public class ConnectRight {
    //Define allNodes to store all the nodes by level to test the result
    public static ArrayList<ArrayList<Node>> allNodes = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        ConnectRight CR = new ConnectRight();
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        Node n7 = new Node(7, null);
        Node[] childrenFor2 = {n5, n6};
        Node n2 = new Node(2, childrenFor2);
        Node n3 = new Node(3, null);
        Node[] childrenFor4 = {n7};
        Node n4 = new Node(4, childrenFor4);
        Node[] childrenFor1 = {n2, n3, n4};
        Node n1 = new Node(1, childrenFor1);
        CR.connectRight(n1);
        // ArrayList<Node> first = allNodes.get(0);
        // System.out.println(first.size());
        ArrayList<String> allLevels = CR.convertLevels(allNodes);
        for (String str : allLevels) {
            System.out.println(str);
        }
    }

    public ArrayList<String> convertLevels(ArrayList<ArrayList<Node>> allNodes) {
        ArrayList<String> allLevels = new ArrayList<String>();
        for (ArrayList list : allNodes) {
            StringBuilder SB = new StringBuilder();
            Node head = (Node)list.get(0);
            SB.append(head.val);
            head = head.Right;
            while (head != null) {
                SB.append("->");
                SB.append(head.val);
                head = head.Right;
            }
            allLevels.add(new String(SB));
        }
        return allLevels;
    }

    public void connect(List<Node> list) {
        Node head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            head.Right = list.get(i);
            head = list.get(i);
        }
        head = list.get(0);
        // while (head != null) {
        //     System.out.print(head.val);
        //     head = head.Right;
        // }
        // System.out.println();
    }

    public Node connectRight(Node root) {
        if (root == null || root.Children == null) {
            return root;
        }
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(root);
        while (list.size() != 0) {
            connect(list);
            allNodes.add(new ArrayList<Node>(list));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node temp = list.remove(0);
                if (temp.Children != null) {
                    for (Node n : temp.Children) {
                        list.add(n);
                    }
                }
            }
        }
        return root;
    }
}
