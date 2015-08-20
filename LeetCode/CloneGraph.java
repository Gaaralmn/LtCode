/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    /**
     * Solution by using iteration.
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        //Clone all nodes for the first step
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int index = 0;
        while (index < nodes.size()) {
            UndirectedGraphNode temp = nodes.get(index++);
            for (int i = 0; i < temp.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = temp.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        //Clone neighbors for each cloned nodes
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode oldNode = nodes.get(i);
            UndirectedGraphNode newNode = map.get(oldNode);
            for (int j = 0; j < oldNode.neighbors.size(); j++) {
                newNode.neighbors.add(map.get(oldNode.neighbors.get(j)));
            }
        }

        return map.get(node);
    }

    /**
     * Solution by using recursion
     */
     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
         return helper(node, map);
     }

     public UndirectedGraphNode helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
         while (node != null && !map.containsKey(node)) {
             map.put(node, new UndirectedGraphNode(node.label));
             for (UndirectedGraphNode graphNode : node.neighbors) {
                 map.get(node).neighbors.add(helper(graphNode, map));
             };
         }
         return map.get(node);
     }
}
