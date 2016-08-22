import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Tree {
	
	static PrintWriter writer = null;

	public static void main(String arg) {
		
		// input (Manual)
		//lvl0
		TreeNode root = new TreeNode("A");
		//lvl1
		root.left = new TreeNode("B");
		root.right = new TreeNode("G");
		//lvl2
		root.left.left = new TreeNode("C");
		root.left.right = new TreeNode("D");
		root.right.right = new TreeNode("H");
		//lvl3
		root.left.right.left = new TreeNode("E");
		root.left.right.right = new TreeNode("F");
		root.right.right.right = new TreeNode("I");
		//Completed Tree Input
		
		
		
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			printTree(root);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			writer.close();
		}
		
		
	}
	
	private static void printTree(TreeNode root) {
		printTree(root, 0);
	}
	
	private static void printTree(TreeNode node, int level) {
		System.out.println("Node = " + node.name + " level = " + level);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < level; i++) {
			sb.append("-");
		}
		sb.append(node.name);
		writer.println(sb.toString());
		
		if(node.left == null && node.right == null) return;
		
		if(node.left != null)
			printTree(node.left, level + 1);
		if (node.right != null)
			printTree(node.right, level + 1);
	}

}

class TreeNode {
	String name;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
		init();
	}
	
	TreeNode(String a) {
		init();
		this.name = a;
	}
	
	private void init() {
		this.name = null;
		this.left = null;
		this.right = null;
	}
}