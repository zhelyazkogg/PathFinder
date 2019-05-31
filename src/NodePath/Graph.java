package NodePath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Graph {

	public HashMap<String, Node> myGraph = new HashMap<>();

	Comparator<Node> byDistance = (Node n1, Node n2) -> Double.compare(n1.distance, n2.distance);
	Comparator<Node> byName = (Node n1, Node n2) -> n1.name.compareTo(n2.name);
	Comparator<Node> byDistanceToGoal = (Node n1, Node n2) -> Double.compare(n1.distanceToGoal, n2.distanceToGoal);
	Comparator<Node> byFloor = (Node n1, Node n2) -> Integer.compare(n1.floor, n2.floor);

	public void addNode(Node node) {
		if (node == null || myGraph.containsKey(node.name)) {
			System.err.println("Node name already exists");
			return;
		}
		myGraph.put(node.name, node);
	}

	public void addLink(String startName, String endName, String typeTransition, double l, boolean isBiDirectional) {
		if (myGraph.containsKey(startName) && myGraph.containsKey(endName)) {
			Node startNode = myGraph.get(startName);
			Node endNode = myGraph.get(endName);
			startNode.links.add(new Link(endName, l, typeTransition));

			if (isBiDirectional) {
				endNode.links.add(new Link(startName, l, typeTransition));
			}
		} else {
			System.err.println("Wrong or missing node names");
		}
	}

	public Node getNode(String name) {
		return myGraph.get(name);
	}

	public boolean containsNode(String name) {
		return myGraph.containsKey(name);
	}

	public ArrayList<Node> getLinkedNodes(String name) {
		ArrayList<Node> linkedNodes = new ArrayList<>();
		Node node = myGraph.get(name);
		for (Link l : node.links) {
			linkedNodes.add(myGraph.get(l.toNodeName));
		}
		return linkedNodes;
	}

	public void resetAllNodes() {
		myGraph.forEach((k, v) -> v.reset());
	}

	public void sortByDistance(ArrayList<Node> list) {
		list.sort(byDistance);
	}

	public void sortByFloor(ArrayList<Node> list) {
		list.sort(byDistance.thenComparing(byFloor));
	}

	public void sortByDistanceToGoal(ArrayList<Node> list) {
		list.sort(byName.thenComparing(byDistance));
	}

	public double findDistance(String nameOne, String nameTwo) {

		Node nodeOne = getNode(nameOne);
		Node nodeTwo = getNode(nameTwo);

		double distance = Math.sqrt(Math.pow(nodeOne.x - nodeTwo.x, 2) + Math.pow(nodeOne.y - nodeTwo.y, 2));
		return distance;
	}
}
