package InputStram;
import java.io.*;
import java.util.*;
public class CharacterSreamBasics {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		File f=new File("E:\\iostreams\\characterBasics.txt");
		File f1=new File("E:\\iostreams\\buyproducts.txt");
		
		FileReader fr=new FileReader(f);
		FileWriter fw=new FileWriter(f1);

		int data;
		char ch[]=new char[(int)f.length()];
		
		String s="bananas, kiwi, potatoes, ";
		fr.read(ch);
		while((data=fr.read())!=-1) {
			System.out.print((char)data);
		
		}
		
		fw.write(s);
		System.out.println();
		System.out.println("any more items you want to add");
		String str=sc.nextLine();
		fw.write(str);
		fw.write(ch);
		fr.close();
		fw.close();
	}

}
