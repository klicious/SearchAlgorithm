import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class XOREncription {

	static String key;
	
	public static void main(String arg) {
		String result = null;
		
		String[] lines = arg.split(System.lineSeparator());
		
		String content = lines[0];
		String key = lines[1];
		
		result = xorEncryption(key, content);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(result);
			writer.println(key);
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
	
	private static String xorEncryption(String key, String value) {
		String result = null;
		byte[] k = key.getBytes();
		byte[] v = value.getBytes();
		byte[] encrypted = new byte[v.length];
		
		for(int i = 0; i < key.length(); i++) {
			encrypted[i] = (byte) (v[i] ^ k[i%k.length]);
		}
		result = new String(encrypted);
		return result;
	}

}
