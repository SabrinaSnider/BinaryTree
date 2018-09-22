import java.util.Scanner;

public class Tree {
	// Makes binary tree
	static Node root = null;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int choice = -1;

		while (choice != 7) {
			System.out.println("Binary Tree");
			System.out.println("1. Insert");
			System.out.println("2. Print 3 Traversals");
			System.out.println("3. Search");
			System.out.println("4. Count");
			System.out.println("5. Edit");
			System.out.println("6. Delete");
			System.out.println("7. Exit");

			System.out.print("Choose an option: ");
			choice = scan.nextInt();
			System.out.println();

			switch (choice) {
			case 1: // Insert
				insert();
				break;
			case 2: // Print 3 Traversals
				System.out.println("Preorder");
				preorder(root);
				System.out.println("\nPostorder");
				postorder(root);
				System.out.println("\nInorder");
				inorder(root);
				System.out.println();
				break;
			case 3: // Search - print number of comparisons
				search(root);
				break;
			case 4: // Count
				System.out.println("There are " + Node.getCount() + " items.");
				break;
			case 5: // Edit
				edit(root);
				break;
			case 6: // Delete
				delete(root);
				break;
			case 7: // Exit
				break;
			default:
				System.out.println("Invalid number entered. Please choose one of the options (1-7).\n");
				break;
			}
			System.out.println();
		}
	}

	public static void insert() {
		System.out.print("Enter in a value to insert: ");
		Scanner scan = new Scanner(System.in);
		Node insert = new Node(scan.nextInt());

		if (root == null) {
			root = insert;
		} else {
			Node prevCheck = root;
			Node pointer = root;
			while (pointer != null) {
				prevCheck = pointer;
				if (insert.getValue() > pointer.getValue()) { // if insert > pointer
					pointer = pointer.getRight();
					if (pointer == null)
						prevCheck.setRight(insert);
				} else { // if insert < pointer
					pointer = pointer.getLeft();
					if (pointer == null)
						prevCheck.setLeft(insert);
				}
			}
		}
	}

	public static void insert(Node insert) {
		if (root == null) {
			root = insert;
		} else {
			Node prevCheck = root;
			Node pointer = root;
			while (pointer != null) {
				prevCheck = pointer;
				if (insert.getValue() > pointer.getValue()) { // if insert > pointer
					pointer = pointer.getRight();
					if (pointer == null)
						prevCheck.setRight(insert);
				} else { // if insert < pointer
					pointer = pointer.getLeft();
					if (pointer == null)
						prevCheck.setLeft(insert);
				}
			}
		}
	}

	public static void preorder(Node pointer) { // pass in root
		if (pointer != null) {
			System.out.print(pointer.getValue() + " ");
			preorder(pointer.getLeft());
			preorder(pointer.getRight());
		}
	}

	public static void inorder(Node pointer) {
		if (pointer != null) {
			inorder(pointer.getLeft());
			System.out.print(pointer.getValue() + " ");
			inorder(pointer.getRight());
		}
	}
	
	public static void postorder(Node pointer) {
		if (pointer != null) {
			postorder(pointer.getLeft());
			postorder(pointer.getRight());
			System.out.print(pointer.getValue() + " ");
		}
	}

	public static void search(Node pointer) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What value are you searching for? ");
		int search = scan.nextInt();

		boolean found = false;
		int count = 0;
		while (pointer != null) {
			count++;
			if (search > pointer.getValue())
				pointer = pointer.getRight();
			else if (search < pointer.getValue())
				pointer = pointer.getLeft();
			else if (search == pointer.getValue()) {
				found = true;
				break;
			}
		}

		if (found == true)
			System.out.println("\nThe value " + search + " was found after " + count + " checks.");
		else
			System.out.println("\nThe value " + search + " was not found after " + count + " checks.");
	}

	public static void edit(Node pointer) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What value do you want to edit? ");
		int val = scan.nextInt();

		boolean found = false;
		while (pointer != null) {
			if (val > pointer.getValue())
				pointer = pointer.getRight();
			else if (val < pointer.getValue())
				pointer = pointer.getLeft();
			else if (val == pointer.getValue()) {
				found = true;
				break;
			}
		}
		if (found == true) {
			System.out.println("\nWhat value do you want to replace " + val + " with? ");
			int newVal = scan.nextInt();
			pointer.setValue(newVal);
			System.out.println("New value set.");
		} else
			System.out.println("\nValue not found in the binary tree.");
	}

	public static void delete(Node pointer) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What value do you want to delete? ");
		int val = scan.nextInt();

		Node parent = null;
		boolean found = false;
		boolean left = false;
		while (pointer != null) {
			if (val > pointer.getValue()) {
				parent = pointer;
				pointer = pointer.getRight();
				left = false;
			} else if (val < pointer.getValue()) {
				parent = pointer;
				pointer = pointer.getLeft();
				left = true;
			} else if (val == pointer.getValue()) {
				found = true;
				break;
			}
		}
		if (found == true) {
			if (pointer.hasLeft() == true && pointer.hasRight() == true) {
				Node right = pointer.getRight();
				
				if (left) parent.setLeft(pointer.getLeft());
				else parent.setRight(pointer.getLeft());
				
				insert(right);
			} else if (pointer.hasLeft() ^ pointer.hasRight()) {
				if (left) parent.setLeft(pointer);
				else parent.setRight(pointer);
			}
		} else {
			System.out.println("\nValue not found in the binary tree.");
		}
	}

}
