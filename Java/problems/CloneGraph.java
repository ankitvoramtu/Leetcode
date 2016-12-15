package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import utilities.UndirectedGraphNode;

public class CloneGraph {
	public static void main(String[] args) {

		CloneGraph a = new CloneGraph();
		UndirectedGraphNode node1 = new UndirectedGraphNode(-1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(1);
		List<UndirectedGraphNode> list1 = new ArrayList<UndirectedGraphNode>();
		list1.add(node2);
		node1.neighbors = list1;
		List<UndirectedGraphNode> list2 = new ArrayList<UndirectedGraphNode>();
		list2.add(node1);
		node2.neighbors = list2;
		a.cloneGraph1(node1);

	}

	// DFS - recursive 1
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
		if (graph == null)
			return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(graph, map);
	}

	private UndirectedGraphNode DFS(UndirectedGraphNode graph,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(graph)) {
			return map.get(graph);
		}
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		map.put(graph, graphCopy);
		for (UndirectedGraphNode neighbor : graph.neighbors) {
			graphCopy.neighbors.add(DFS(neighbor, map));
		}
		return graphCopy;
	}

	// DFS - recursive 2
	public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		helper(node, map);
		return map.get(node);
	}

	private void helper(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode cur = node.neighbors.get(i);
			if (!map.containsKey(cur)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
				map.put(cur, copy);
				helper(cur, map);
			}
			map.get(node).neighbors.add(map.get(cur));
		}
	}

	// DFS - iterative
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		stack.push(node);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		while (!stack.isEmpty()) {
			UndirectedGraphNode cur = stack.pop();
			for (int i = 0; i < cur.neighbors.size(); i++) {
				if (!map.containsKey(cur.neighbors.get(i))) {
					copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
					map.put(cur.neighbors.get(i), copy);
					stack.push(cur.neighbors.get(i));
				}
				map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
			}
		}
		return map.get(node);
	}

	// BFS
	public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (int i = 0; i < cur.neighbors.size(); i++) {
				if (!map.containsKey(cur.neighbors.get(i))) {
					copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
					map.put(cur.neighbors.get(i), copy);
					queue.offer(cur.neighbors.get(i));
				}
				map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
			}
		}
		return map.get(node);
	}
}
