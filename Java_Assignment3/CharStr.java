package first;
import java.io.*;
import java.util.Scanner;

class CharStr {
public static void main(String[] args) throws IOException {
	
	// opening the file
	try {
		File file = new File("D:\\eclipse\\Midsems\\src\\first");
		if(file.createNewFile()) {
			System.out.println("Successfully opened the file");
		}else {
			System.out.println("File already exists");
		}
	}catch(IOException e) {
		System.out.println("Error in opening the file");
		e.printStackTrace();
	}
	
	// writing content in the file
	try {
		FileWriter mywriter = new FileWriter("D:\\eclipse\\Midsems\\src\\first\\file.txt");
		mywriter.write("This is my first content");
		mywriter.close();
		System.out.println("Successfully wrote to the file");
	}catch(IOException e) {
		System.out.println("Error in writing to the file");
		e.printStackTrace();
	}
	
	// reading from the file
	try {
		File file = new File("D:\\eclipse\\Midsems\\src\\first\\file.txt");
		Scanner myreader = new Scanner(file);
		while(myreader.hasNextLine()) {
			String data = myreader.nextLine(); 
			System.out.println(data);
		}
		myreader.close();
	}catch(IOException e) {
		System.out.println("Error occurred in reading from file");
		e.printStackTrace();
	}
}
}