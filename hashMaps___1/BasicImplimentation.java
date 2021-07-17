package hashMaps___1;
import java.util.HashMap;
import java.util.Set;

public class BasicImplimentation {
	
	public static void main(String[] args) {
		HashMap<String,Integer> map=new HashMap<>();
		
		map.put("abc", 1);
		map.put("def", 2);
		map.put("ghi", 3);
		
		System.out.println(map.containsKey("abc"));
		
		System.out.println(map.containsKey("abc1"));
		
		System.out.println(map.size());
		System.out.println(map.get("abc"));
		map.put("abc", 90);
		System.out.println(map.get("abc"));
		map.remove("abc");
		System.out.println(map.size());
		//int a=map.get("abc");
		
		Set<String > keys=map.keySet();
		for(String s:keys) {
			System.out.println(s+" "+map.get(s));
		}
		
		
		
	}
}
