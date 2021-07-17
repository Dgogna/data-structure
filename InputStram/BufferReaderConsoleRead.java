package InputStram;
import java.io.*;
public class BufferReaderConsoleRead {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr=new InputStreamReader(System.in);
		
		BufferedReader br=new BufferedReader(isr);
		
		String data="";
		
		while(!data.equals("stop")) {
			System.out.println("EnterThe data");
			data=br.readLine();
			System.out.println("Data is "+data);
		}
		
		br.close();
		isr.close();
		
//		System.out.println("Enter Your Name");
//		String name=br.readLine();
//		
//		System.out.println("welcome: "+name);

	}

}
