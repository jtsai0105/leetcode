/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        node.neighbors.stream().forEach(neighbor -> {
            copyNode.neighbors.add(cloneGraph(neighbor));
        });
        
        return copyNode;
    }
}
