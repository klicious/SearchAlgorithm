import java.io.BufferedReader;
import java.io.FileReader;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String line;
		String binarySearchInput = null;
		String printTreeInput = null;
		String linkedListInput = null;
		String xorEncryptionInput = null;
		String dfsInput = null;
		//Binary Search
		try (BufferedReader br = new BufferedReader(new FileReader ("binary_search_input.txt"))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			binarySearchInput = sb.toString();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (binarySearchInput == null) {
			System.out.println("Search.java :: main() :: No strings read from selection_sort_input.txt thus HALTing....");
			return;
		}
		System.out.println("============================================");
		System.out.println("Binary Search Called");
		System.out.println("============================================");
		BinarySearch.main(binarySearchInput);
		System.out.println("Search.java :: main() :: Binary Search : " +  verifyResult("output.txt", "binary_search_expected_output.txt"));
		
		//Print Tree
		System.out.println("============================================");
		System.out.println("Print Tree Called");
		System.out.println("============================================");
		Tree.main(printTreeInput);
		System.out.println("Search.java :: main() :: Print Tree : " +  verifyResult("output.txt", "print_tree_expected_output.txt"));
		
		//Linked List
		try (BufferedReader br = new BufferedReader(new FileReader ("linked_list_input.txt"))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			linkedListInput = sb.toString();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (linkedListInput == null) {
			System.out.println("Search.java :: main() :: No strings read from selection_sort_input.txt thus HALTing....");
			return;
		}
		System.out.println("============================================");
		System.out.println("Linked List Called");
		System.out.println("============================================");
		LinkedList.main(linkedListInput);
		System.out.println("Search.java :: main() :: Linked List : " +  verifyResult("output.txt", "linked_list_expected_output.txt"));
		
		//XOR Encryption
		try (BufferedReader br = new BufferedReader(new FileReader ("xor_encryption_input.txt"))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			xorEncryptionInput = sb.toString();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (xorEncryptionInput == null) {
			System.out.println("Search.java :: main() :: No strings read from xorencryption_input.txt thus HALTing....");
			return;
		}
		System.out.println("============================================");
		System.out.println("XOR Encryption Called");
		System.out.println("============================================");
		XOREncription.main(xorEncryptionInput);
		System.out.println("Search.java :: main() :: XOR Encryption : " +  verifyResult("output.txt", "xor_encryption_expected_output.txt"));
		
		//Depth First Search
		dfsInput = getInputFromFile("dfs_input.txt");
		
		if (dfsInput == null) {
			System.out.println("Search.java :: main() :: No strings read from dfs_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println("DFS Called");
		System.out.println("============================================");
		DFS.main(dfsInput);
		System.out.println("Search.java :: main() :: DFS : " +  verifyResult("output.txt", "dfs_expected_output.txt"));
		
	}
	
	private static String getInputFromFile(String path) {
		String line;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader (path))){
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().trim();
	}
	
	private static boolean verifyResult(String outputFile, String expectedOutputFile) {
		String output = "output";
		String expectedOutput = "expectedOutput";
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader (outputFile))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			output = sb.toString();
			System.out.println("Sort.java :: verifyResult() :: output : " + System.lineSeparator() + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader (expectedOutputFile))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			expectedOutput = sb.toString();
			System.out.println("Sort.java :: verifyResult() :: expected_output : " + System.lineSeparator() + expectedOutput);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output.equals(expectedOutput);
	}

}
