package PRACTICO_2;

public class Root {

	int content;
	Root left, right;
	
	public Root (int content) {
		this.content = content;
		this.left = null;
		this.right = null;
	}
	
	public void setRight (Root root) {
		this.right = root;
	}
	public void setLeft (Root root) {
		this.left = root;
	}
	public Root getRight () {
		return this.right;
	}
	public Root getLeft () {
		return this.left;
	}
	public int getContent () {
		return this.content;
	}
	public void changeContent (int newInt) {
		this.content = newInt;
	}
	
}
