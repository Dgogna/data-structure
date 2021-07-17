package hashMaps___1;

public class MapUse {

	public static void main(String[] args) {
		Map<String ,Integer> my=new Map<>();
		
		for(int i=0;i<20;i++) {
			my.insert("abc"+i, i+1);
			System.out.println(my.loadFactor());
		}
		
		my.delete("abc3");
		my.delete("abc7");
		
		for(int i=0;i<20;i++) {
			System.out.println("abc"+i+":"+ my.getValue("abc"+i));
		}
	}
}
