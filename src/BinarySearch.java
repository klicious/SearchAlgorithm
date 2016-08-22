import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class BinarySearch {

	public static void main(String arg) {
		
		int result = -1;
		
		String line = arg.replaceAll(System.lineSeparator(), " ");
		
		String[] lines = line.split(" ");
		
		int n = Integer.parseInt(lines[0].trim());
		
		int[] search = new int[n];
		
		for(int i = 0; i < n; i++) {
			search[i] = Integer.parseInt(lines[i+1]);
		}
		
		int value = Integer.parseInt(lines[n + 1]);
		
		//int resultIndex = binarySearch(search, value);
		
		result = binarySearch(search, value);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(++result);
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
	
	private static int binarySearch(int[] a, int value) {
		int max = a.length - 1;
		int min = 0;
		
		return binarySearch(a,value,min,max);
	}
	
	private static int binarySearch(int[] a, int value, int min, int max) {
		int result = -1;
		
		int nodeIndex = (min + max)/2;
		
		if(min > max) return -1;
		
		//System.out.println("min = " + min + " max = " + max + " Value = " + value + " NodeIndex = " + nodeIndex + " NodeValue = " + a[nodeIndex] + " alength = " + a.length);
		if( a[nodeIndex] == value) {
			return nodeIndex;
		} else if(a[nodeIndex] < value) {
			result = binarySearch(a,value,nodeIndex+1, max);
		} else if(a[nodeIndex] > value) {
			result = binarySearch(a,value,min,nodeIndex-1);
		}
		
		return result;
	}

}
