package InputStram;
import java.io.*;
public class BasicsOfIoStrams {

	public static void main(String[] args) throws FileNotFoundException,IOException   {
		
		FileInputStream my = new FileInputStream("E:\\iostreams\\temp.txt"); 
		// true is used only for appending
		FileOutputStream myos = new FileOutputStream("E:\\iostreams\\temp3.txt",true);

		int i;
		while((i=my.read())!=-1) {
			System.out.print((char)i);
		}

		my.close();
		myos.write(95);
		myos.close();
        
		
	


	}

}
