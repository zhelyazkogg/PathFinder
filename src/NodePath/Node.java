package NodePath;

import java.util.ArrayList;

public class Node {

	public String name;
	public int floor;
	public int x, y;
	public String typeRoom;

	boolean isTested = false;
	boolean isExpanded = false;
	int depth = -1;
	double distanceToGoal = 0.0;
	double distance;
	Node parent = null;
	String typeTransition;

	public ArrayList<Link> links = new ArrayList<>();

	public Node(String name) {
		this.name = name;
	}

	public Node(String name, int x, int y, int floor, String typeRoom) {
		this(name);
		this.x = x;
		this.y = y;
		this.floor = floor;
		this.typeRoom = typeRoom;
	}

	public void reset() {
		this.isExpanded = false;
		this.isTested = false;
		this.depth = -1;
		this.distanceToGoal = 0.0;
		this.parent = null;
	}
}