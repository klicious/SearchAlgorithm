import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class LinkedList {

	static Node root;
	
	public static void main(String arg) {
		// TODO Auto-generated method stub
		String line = arg.replaceAll(System.lineSeparator(), " ");
		
		String[] lines = line.split(" ");
		
		int n = Integer.parseInt(lines[0].trim());
		
		int[] list = new int[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(lines[i+1]);
		}
		
		int node = Integer.parseInt(lines[n + 1]);
		
		int location = Integer.parseInt(lines[n + 2]);

		//root = new Node(Integer.parseInt(lines[1]));
		/*
		 * System.out.println("=============");
		 * System.out.println("root val = " + root.value);
		*/
		
		System.out.println("=====list=====");
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		System.out.println("=====");
		System.out.println("=====lines=====");
		for(int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
		System.out.println("=====");
		System.out.println("n = " + n);
		
		for(int i = 0; i < n; i++) {
			add(Integer.parseInt(lines[i+1]));
			System.out.println("lines[i+1] = " + lines[i+1] + " :: " + printRoot());
			
		}
		// finish input
		
		System.out.println("=====");
		Node tmp = root;
		while(tmp.next != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
		System.out.println("=====");
		
		add(node, location);
		
		//write output.txt
		String result = printRoot();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(result);
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

	private static String printRoot() {
		StringBuilder sb =  new StringBuilder();
		Node cur = root;
		while(cur != null) {
			sb.append(cur.value);
			sb.append(" ");
			cur = cur.next;
		}
		
		String result = sb.toString().trim();
		return result;
	}
	
	private static void add(int val) {
		
		if (root == null) {
			root = new Node(val);
			return;
		}
		
		Node cur = root;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node(val);
	}
	
	private static void add(int val, int loc) {
		
		if(root.next == null) {
			root.next = new Node(val);
		}
		
		Node prev = null;;
		Node cur = root;
		System.out.println("root value = " + root.value + " cur value = " + cur.value) ;
		int i = 0;
		while(cur.next != null && i < loc) {
			i++;
			prev = cur;
			cur = cur.next;
			System.out.println(prev.value);
		}
		
		prev.next = new Node(val);
		prev.next.next = cur;
		
	}

}

class Node {
	int value;
	Node next;
	
	Node() {
		init();
	}
	
	Node(int val) {
		init();
		this.value = val;
	}
	
	private void init(){
		this.value = -1;
		this.next = null;
	}
}
