import java.io.*;

public class CaseConversion {

	public static void main(String[] args) throws IOException {
		
		boolean t = false;
		
		if (args[0].equalsIgnoreCase("-L")) {
			t = true;
		} else if (args[0].equalsIgnoreCase("-U")){
			t = false;
		} else {
			System.out.println("輸入錯誤");
		}
		
		try (FileReader fin = new FileReader("source.txt");
			 FileWriter fw  = new FileWriter("result.txt")){
			
			char[] input = new char[32];
			int count = 0;
			
			while((count = fin.read(input)) > 0 ) {
				String line = new String(input, 0, count);
				String output = "";
				if(t) {
					output = line.toLowerCase();
				} else {
					output = line.toUpperCase();
				}
				
				fw.write(output);
			}
			
			fw.flush();
			System.out.println("輸出成功!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
