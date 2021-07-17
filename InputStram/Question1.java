package InputStram;
import java.io.*;
public class Question1 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("E:\\iostreams\\question.txt");

		BufferedReader br=new BufferedReader(fr);

		StreamTokenizer st=new StreamTokenizer(br);

		int token=0;
		double sum=0;
		while((token=st.nextToken())!=StreamTokenizer.TT_EOF) {

			switch(token) {
				case StreamTokenizer. TT_NUMBER:
				{
					//System.out.println(st.nval);
					sum+=st.nval;
					//System.out.println(sum);
					break;
				}
				case StreamTokenizer. TT_WORD:
				{
					if(sum!=0) {
						System.out.println((int)sum);
					}
					System.out.print(st.sval+" ");
					sum=0;
					break;
				}
			}
		}
		System.out.println((int)sum);

	}

}
