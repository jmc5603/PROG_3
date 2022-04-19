package PRACTICO_2;

public class Tree {

	private Root root;
	
	public Tree () {
		this.root = null;
	}
	public Tree (Root root) {
		this.root = root;
	}
	public int getRoot () {
		return this.root.getContent();
	}
	public Boolean isEmpty () {
		if (this.root == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean hasElement (int element) {
		return hasElement(element, this.root);
	}
	public Boolean hasElement (int element, Root root) {
		if (root.getContent() != element) {
			if (element > root.getContent()) {
				if (root.getRight() != null) {
					return hasElement(element, root.getRight());
				}
				else {
					return false;
				}
			}
			else {
				if (root.getLeft() != null) {
					return hasElement(element, root.getLeft());
				}
				else {
					return false;
				}
			}
		}
		else {
			return true;
		}
	}
	public void insert (int element) {
		insert(element, this.root);
	}
	public void insert (int element, Root root) {
		if (root.getContent() == element) {
			System.out.println("El elemento '" + element + "' ya forma parte del arbol binario...");
		}
		else if (element > root.getContent()) {
			if (root.getRight() == null) {
				root.setRight(new Root(element));
			}
			else {
				insert(element, root.getRight());
			}
		}
		else {
			if (root.getLeft() == null) {
				root.setLeft(new Root(element));
			}
			else {
				insert(element, root.getLeft());
			}
		}
	}
	public Boolean delete(int element, Root root) {
		if (element > root.getContent()) {
			return delete(element, root.getRight());
		}
		else if (element < root.getContent()) {
			return delete(element, root.getLeft());
		}
		else {
			
		}
	}
	public int getHeight() {
		
	}
	
}
