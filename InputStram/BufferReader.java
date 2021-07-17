package InputStram;
import java .io.*;
public class BufferReader {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		FileReader fr=new FileReader("E:\\iostreams\\demo.txt");
		
		BufferedReader br=new BufferedReader(fr);
		
		int data;
		while((data=br.read())!=-1) {
			System.out.print((char)data);
		}
		
		br.close();
		fr.close();

	}

}
