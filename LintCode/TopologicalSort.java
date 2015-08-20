/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class TopologicalSort {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     * @Can be solved with both DFS and BFS
     */
    //BFS Solution
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }
        while (queue.size() != 0) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                //Really important step to prevent repetition
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }

    //DFS Solution
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!visited.contains(node)) {
                search(result, visited, node);
            }
        }
        return result;
    }
    public void search(ArrayList<DirectedGraphNode> result, Set<DirectedGraphNode> visited, DirectedGraphNode node) {
        visited.add(node);
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                search(result, visited, neighbor);
            }
        }
        //Important step to promise the right order
        result.add(0, node);
    }
}
