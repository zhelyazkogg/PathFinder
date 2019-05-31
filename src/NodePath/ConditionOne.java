package NodePath;

import java.util.ArrayList;

public class ConditionOne implements PathFinding {

	Graph myMap;
	String startName;
	private Main instance;

	public ConditionOne(Graph g) {
		this.myMap = g;
	}

	@Override
	public boolean pathFind(String startName, String endName) {
		if (!myMap.containsNode(startName) || !myMap.containsNode(endName)) {
			return false;
		}

		this.startName = startName;
		Node startNode = myMap.getNode(startName);
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(startNode);

		Node temp;

		while (!queue.isEmpty()) {
			temp = queue.get(0);
			setParentAndCost(temp);

			if (temp.parent != null)
				instance.resultTextArea.append("\nTemp node is: " + temp.name + " , parent " + temp.parent.name
						+ " , cost " + temp.distanceToGoal + " , transition " + temp.typeTransition + "	");

			if (temp.name.equals(endName)) {
				printPath(endName);
				return true;
			}

			temp.isTested = true;
			queue.remove(0);

			for (Node node : myMap.getLinkedNodes(temp.name)) {
				if (!node.isExpanded && !queue.contains(node)) {
					if (node.typeTransition.equals("climb")) {
						continue;
					}
					queue.add(node);
				}
			}
			myMap.sortByDistance(queue);
			temp.isExpanded = true;

		} // end while

		printPath(endName);
		return (myMap.getNode(endName).parent != null);
	}

	private void setParentAndCost(Node node) {

		Node temp;
		for (Link l : node.links) {
			if (l.toNodeName.equals(startName))
				continue;
			temp = myMap.getNode(l.toNodeName);
			temp.typeTransition = l.transition;
			if ((temp.parent == null) || (temp.distanceToGoal > node.distanceToGoal + l.length)) {
				temp.parent = node;
				temp.distanceToGoal = node.distanceToGoal + l.length;
			}
		}
	}

	public void printPath(String name) {
		Node node = myMap.getNode(name);
		StringBuilder path = new StringBuilder();
		do {
			path.append(" " + new StringBuilder(node.name).reverse().toString());
			node = node.parent;
		} while (node != null);
		path.reverse();
		instance.resultTextArea.append("\n" + path + " cost: " + myMap.getNode(name).distanceToGoal);
	}
}
