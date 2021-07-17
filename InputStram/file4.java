package InputStram;
import java.io.*;
import java.util.*;
public class file4 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("E:\\iostreams\\streamtoken.txt");

		StreamTokenizer st = new StreamTokenizer(fr);
		
		int token=0;
		while(true) {
			
			token=st.nextToken();
			
			if(token==StreamTokenizer. TT_EOF) {
				break;
			}
			
			if(token==StreamTokenizer. TT_NUMBER) {
				System.out.println(st.nval);
			}
			
			if(token==StreamTokenizer. TT_WORD) {
				System.out.println(st.sval);
			}
		}
	}

}
