package tries;

public class TrieUse {
	
	public static void main(String[] args) {
		Trie my=new Trie();
		my.add("hello");
		my.add("welcome");
		
		System.out.println(my.search("hello"));
		
		System.out.println(my.countWords());
		my.delete("hello");
		System.out.println(my.search("hello"));
		System.out.println(my.countWords());
		
		
	}
	
}
