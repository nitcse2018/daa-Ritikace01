package first;
import java.io.*;

public class ByteStr{
	public static void main(String[] args) throws IOException {
		// reading data from the file
		FileInputStream file = new FileInputStream("D:\\eclipse\\Midsems\\src\\first\\file2.txt");
		int data;
		try {
			while((data = file.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			file.close();
		}catch(IOException e) {
			System.out.println("Error in reading the file");
			e.printStackTrace();
		}
		
		// writing data in a file
		try{
			FileOutputStream writer = new FileOutputStream("D:\\eclipse\\Midsems\\src\\first\\file2.txt");
			String info = "I am adding some new data";
			byte[] convert = info.getBytes();
			writer.write(convert);
			writer.close();
			System.out.println("Successfully wrote to the file");
		}catch(IOException e) {
			System.out.println("Error in writing content to the file");
			e.printStackTrace();
		}
}
}