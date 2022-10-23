package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    private Map<Node, Node> nodesMapping;

    private Node cloneGraphRecursive(final Node node) {
        if(node == null) {
            return null;
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        nodesMapping.put(node, newNode);

        for (final Node neighbor : node.neighbors) {
            Node newNeighbour = nodesMapping.get(neighbor);
            if (newNeighbour == null) {
                newNeighbour = cloneGraphRecursive(neighbor);
            }
            newNode.neighbors.add(newNeighbour);
        }
        return newNode;
    }

    public Node cloneGraph(final Node node) {
        nodesMapping = new HashMap<>();
        return cloneGraphRecursive(node);
    }

    public static void main(String[] args) {
        final CloneGraph cloneGraph = new CloneGraph();
        final Node node1 = new Node(1, new ArrayList<>());
        final Node node2 = new Node(2, new ArrayList<>());
        final Node node3 = new Node(3, new ArrayList<>());
        final Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        final Node result = cloneGraph.cloneGraph(node1);
        System.out.println(result);
    }
}
