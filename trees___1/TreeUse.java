package trees___1;
import java.util.Scanner;
import java.util.*;

public class TreeUse {

	public static int CountLeafNodes(TreeNode<Integer> root) {
		if(root.children.isEmpty()) {
			 return 1;
		}
		int count=0;
		for(int i=0;i<root.children.size();i++) {
			int leaf=CountLeafNodes(root.children.get(i));
			count+=leaf;
		}
		return count;
	}
	
	public static void nodesAtK(TreeNode<Integer> root,int k) {
		if(k==0) {
			System.out.print(root.data+" ");
		}
		for(int i=0;i<root.children.size();i++) {
			nodesAtK(root.children.get(i), k-1);
		}
	}
	
	public static int height(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int height=0;
		for(int i=0;i<root.children.size();i++) {
			int h=height(root.children.get(i));
			if(h>height) {
				height=h;
			}
		}
	
		return height+1;
	}
	
	public static int largestNode(TreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int lar=root.data;
		for(int i=0;i<root.children.size();i++) {
			int num=largestNode(root.children.get(i));
			if(num>lar) {
				lar=num;
			}
		}
		return lar;
	}
	
	public static int countNodes(TreeNode<Integer> root) {
		// this is not a base case but it is a edge case
		if(root==null) {
			return 0;
		}
		int count=0;
		for(int i=0;i<root.children.size();i++) {
			count+=countNodes(root.children.get(i));
		}
		
		return count+1;
		
	}
	
	public static TreeNode<Integer> takeinput(Scanner s){
		
		//Scanner s=new Scanner(System.in);
		System.out.println("Enter the nextNode data");
		int n=s.nextInt();
		TreeNode<Integer> root=new TreeNode<>(n);
		System.out.println("enter the number of children for"+ n);
		int childcount=s.nextInt();
		for(int i=0;i<childcount;i++) {
			TreeNode<Integer> child=takeinput(s);
			root.children.add(child);
		}
		return root;
	}
	
	public static TreeNode<Integer> takeInputLevel(){
		Scanner s=new Scanner(System.in);
		System.out.println("tell the root node");
		int n=s.nextInt();
		TreeNode<Integer> root=new TreeNode<>(n);
		Queue<TreeNode<Integer>> my=new LinkedList<>();
		my.add(root);
		while(!my.isEmpty()) {
			TreeNode<Integer> front=my.poll();
			System.out.println("tell the no of children of "+ front.data);
			int children=s.nextInt();
			for(int i=0;i<children;i++) {
				System.out.println("tell the "+(i+1)+" child of "+front.data);
				int childinput=s.nextInt();
				TreeNode<Integer> child=new TreeNode<>(childinput);
				my.add(child);
				front.children.add(child);
			}
		}
		
		s.close();
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String str=root.data+":";
		for(int i=0;i<root.children.size();i++) {
			str+=root.children.get(i).data+", ";
		}
		System.out.println(str);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> my=new LinkedList<>();
		my.add(root);
		my.add(null);
		
		while(!my.isEmpty()) {
			TreeNode<Integer> front=my.poll();
			if(front!=null) {
				System.out.print(front.data+" ");
				for(int i=0;i<front.children.size();i++) {
					my.add(front.children.get(i));
				}
			}
			else {
				System.out.println();
				if(!my.isEmpty()) {
					my.add(null);
				}
			}
		}
	}
	
	
		
	
	
	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		TreeNode<Integer> root=takeinput(s);
		
		TreeNode<Integer> root=takeInputLevel();

		printLevelWise(root);
//		int ans=countNodes(root);
//		System.out.println("Total no of nodes in he tree is "+ans);
//		int lar=largestNode(root);
//		System.out.println("the largest Node is "+lar);
//		int height=height(root);
//		System.out.println("the height of the tree is "+ height);
//		System.out.print("nodes at a lavel ");
//		nodesAtK(root,1);
//		System.out.println();
//		int leafcount=CountLeafNodes(root);
//		System.out.println("the no of leaf nodes are "+leafcount);
		
		

		
		
		
		
	}

}
