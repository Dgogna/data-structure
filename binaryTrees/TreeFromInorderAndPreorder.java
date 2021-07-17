package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFromInorderAndPreorder {
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> my=new LinkedList<>();
		if(root==null) {
			return;
		}
		my.add(root);
		while(!my.isEmpty()) {
			BinaryTreeNode<Integer> front=my.poll();
			System.out.print(front.data);
			if(front.left!=null) {
				System.out.print(":L:"+front.left.data);
				my.add(front.left);
			}
			else if(front.left==null) {
				System.out.print(":L:"+ -1);
			}
			if(front.right!=null) {
				System.out.print(",R:"+front.right.data);
				my.add(front.right);
			}
			else if(front.right==null) {
				System.out.print(",R:"+ -1);
			}
			System.out.println();

		}
	}
	
	public static BinaryTreeNode<Integer> func(int in[], int pre[], int siIn, int eiIn, int siPre, int eiPre){
		if(siIn>eiIn) {
			return null;
		}
		int front=pre[siPre];
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(front);
		int breakPoint=-1;
		for(int i=siIn;i<=eiIn;i++) {
			if(in[i]==front) {
				breakPoint=i;
				break;
			}
		}
		int smallin1=siIn;
		int smallin1end=breakPoint-1;
		int smallin2=breakPoint+1;
		int smallin2end=eiIn;
		int length=smallin1end-smallin1+1;
		int smallpre1=siPre+1;
		int smallpre1end=smallpre1+length-1;
		int smallpre2=smallpre1end+1;
		int smallpre2end=eiPre;
//		
//		System.out.println( smallin1+" "+ smallin1end+" "+ smallpre1+" "+ smallpre1end);
//		System.out.println( smallin2+" "+ smallin2end+" "+ smallpre2+" "+ smallpre2end);
		root.left=func(in, pre, smallin1, smallin1end, smallpre1, smallpre1end);
		root.right=func(in, pre, smallin2, smallin2end, smallpre2, smallpre2end);
		
//		root.left=left;
//		root.right=right;
		
		return root;
				
	}
	
	public static BinaryTreeNode<Integer> preAndIn(int in[], int pre[]){
		BinaryTreeNode<Integer> root=func(in, pre, 0, in.length-1, 0, pre.length-1);
		return root;
	}

	public static void main(String[] args) {
		int in[]= {4,2,5,1,6,3,7};
		int pre[]= {1,2,4,5,3,6,7};
		BinaryTreeNode<Integer> root=preAndIn(in, pre);
		printLevelWise(root);
	}
}
