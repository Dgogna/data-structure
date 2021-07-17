package tries;

public class Trie {
	
	TrieNode root;
	int count;
	
	public Trie() {
		root=new TrieNode('\0');
		count=0;
	}
	
	private void add(TrieNode root,String str) {
		
		if(str.length()==0) {
			root.isTerminating=true;
			return;
		}
		
		int index=str.charAt(0)-'a';
		TrieNode child=root.children[index];
		if(child==null) {
			child=new TrieNode(str.charAt(0));
			root.childCount++;
		//	root.countTerminating++;
			root.children[index]=child;
		}
		
		add(child,str.substring(1));
	}
	public void add(String str) {
		add(root,str);
		count++;
	}
	
	private boolean search (TrieNode root,String word) {
		if(word.length()==0 && root.isTerminating) {
			return true;
		}
		else if(word.length()==0 && !root.isTerminating){
            return false;
        }
		int index=word.charAt(0)-'a';
		TrieNode child=root.children[index];
		if(child==null) {
			return false;
		}
		boolean ans=search(child,word.substring(1));
		return ans;
	}
	public boolean search(String word) {
		return search(root,word);
	}
	
	private void delete(TrieNode root, String word) {
		if(word.length()==0) {
			root.isTerminating=false;
			return;
		}
		int index=word.charAt(0)-'a';
		TrieNode child=root.children[index];
		if(child==null) {
			return;
		}
		delete(child,word.substring(1));
		// now we want to delete that node also in the array.
		if(!child.isTerminating && child.childCount==0) {
			root.children[index]=null;
			child=null;
		//	root.countTerminating--;
			root.childCount--;
		}
	}
	public void delete(String word) {
		delete(root,word);
		count--;
	}

	
	public int countWords() {
		//return countWords(root,0);
		return count;
	}
	
	
}

