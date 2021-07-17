package tries;
import java.util.*;
public class AutoComplete {
	
	public static void print(TrieNode root,String str) {
		if(root.isTerminating) {
			System.out.println(str);
			if(root.childCount==0) {
				return;
			}
		}
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) {
				print(root.children[i],str+root.children[i].data);
			}
		}
	}
	
	public static void autoComplete(TrieNode root, String word,String word1) {
//		TrieNode root=new TrieNode('\0');
		if(word.length()==0) {
			print(root, word1);
			return;
		}
		int index=word.charAt(0)-'a';
		TrieNode child=root.children[index];
		if(child==null) {
			return;
		}
		autoComplete(child,word.substring(1),word1);
		
//		print(my.root,"");
	}

	public static void main(String[] args) {
		ArrayList<String> str=new ArrayList<>();
		str.add("do");
		str.add("dont");
		str.add("no");
		str.add("not");
		str.add("note");
		str.add("notes");
		str.add("den");
		String word="no";
		
		Trie my=new Trie();
		for(int i=0;i<str.size();i++) {
			my.add(str.get(i));
		}
		
		autoComplete(my.root,word,word);

	}
}
