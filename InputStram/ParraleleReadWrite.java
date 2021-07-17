package InputStram;
import java.io.*;
import java.util.*;
public class ParraleleReadWrite {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter the source file");
		String src=s.nextLine();
		System.out.println("enter the destination file");
		String des=s.nextLine();
		
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(des,true);
		
		int data;
		while((data=fis.read())!=-1) {
			fos.write(data);
		}
		
		System.out.println("data written succesfully");
		fis.close();
		fos.close();
		
	//	E:\\iostreams\\monday.txt

	}

}
