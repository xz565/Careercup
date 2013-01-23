package chp04_TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * Given a directed graph, design an algorithm to 
 * find out whether there is a route between two nodes
 */
public class Question4_2 {

	public static boolean hasRoute(GraphNode n1, GraphNode n2) {
		return hasRouteHelper(n1, n2) || hasRouteHelper(n2, n1);
	}
	
	public static boolean hasRouteHelper(GraphNode n1, GraphNode n2) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Stack<GraphNode> nodeStack = new Stack<GraphNode>();
		nodeStack.push(n1);
		visited.add(n1);
		while(!nodeStack.isEmpty()) {
			GraphNode currt = nodeStack.pop();
			for(GraphNode gn : currt.neighbours) {
				if(!visited.contains(gn)) {
					if(gn == n2) {
						return true;
					}
					nodeStack.push(gn);
					visited.add(gn);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		
		n1.addNeighours(n3, n5);
		n2.addNeighours(n3, n4);
		n3.addNeighours(n4);
		
		System.out.println(hasRoute(n1, n2));
		System.out.println(hasRoute(n3, n5));
		System.out.println(hasRoute(n4, n1));
	}
}

class GraphNode {
	int value;
	List<GraphNode> neighbours;
	
	public GraphNode(int val) {
		value = val;
		neighbours = new ArrayList<GraphNode>();
	}
	
	public void addNeighours(GraphNode... neighbourNodes) {
		for(GraphNode gn : neighbourNodes) {
			neighbours.add(gn);
		}
	}
	
	public String toString() {
		return value + "";
	}
}