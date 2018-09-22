
public class Node {

	private int value;
	Node left = null;
	Node right = null;
	private static int count = 0;

	public Node() {
		count++;
	}

	public Node(int value) {
		setValue(value);
		count++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public boolean hasLeft() {
		if (left != null) return true;
		else return false;
	}
	
	public boolean hasRight() {
		if (right != null) return true;
		else return false;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int newCount) {
		count = newCount;
	}
}
