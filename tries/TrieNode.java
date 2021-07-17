package tries;

public class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	
	public TrieNode(char data) {
		this.data=data;
		isTerminating=false;
		children=new TrieNode[26];
		childCount=0;
		
	}
	
}
