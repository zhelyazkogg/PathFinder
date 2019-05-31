package NodePath;

public class Link {
	public String toNodeName;
	public double length;
	public String transition;

	public Link(String name) {
		this.toNodeName = name;
	}

	public Link(String name, double l, String transition) {
		this.toNodeName = name;
		this.length = l;
		this.transition = transition;
	}
}
