package BST___1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import binaryTrees.BinaryTreeNode;
import linkedList_____1.Node;

public class BinarySearchTreeUse {

	public static boolean isBSTbest(BinaryTreeNode<Integer> root, int min, int max) {
		if(root==null) {
			return true;
		}
		
		if(root.data<min || root.data>max) {
			return false;
		}
		
		boolean left=isBSTbest(root.left,min,root.data-1);
		boolean right=isBSTbest(root.right,root.data,max);
		
		return left && right;
	}
	
	public static tripleReturn isBSTbetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			tripleReturn ans=new tripleReturn(true,Integer.MAX_VALUE,Integer.MIN_VALUE);
			return ans;
		}
		
		tripleReturn left=isBSTbetter(root.left);
		tripleReturn right=isBSTbetter(root.right);
		
		boolean isbst=true;
		if(root.data<left.maximum) {
			isbst=false;
		}
		if(root.data>right.minimum) {
			isbst=false;
		}
		if(!left.isBst) {
			isbst=false;
		}
		if(!right.isBst) {
			isbst=false;
		}
		int min=Math.min(root.data, Math.min(left.minimum, right.minimum));
		int max=Math.max(root.data, Math.max(left.maximum, right.maximum));
		tripleReturn ans=new tripleReturn(isbst,min,max);
		return ans;
		
	}

	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int left=minimum(root.left);
		int right=minimum(root.right);

		return Math.min(root.data,Math.min(left, right));
	}

	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int left=maximum(root.left);
		int right=maximum(root.right);

		return Math.max(root.data,Math.max(left, right));
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftmax=maximum(root.left);
		int rightmin=minimum(root.right);

		if(root.data<leftmax) {
			return false;
		}
		if(root.data>rightmin) {
			return false;
		}

		boolean left=isBST(root.left);
		boolean right=isBST(root.right);

		return left&&right;
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Queue<BinaryTreeNode<Integer>> my=new LinkedList<>();
		Scanner s=new Scanner(System.in);
		System.out.println("enter the root element");
		int rootdata=s.nextInt();
		if(rootdata==-1) {
			return null;               // this is an edge case not the base case.
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);
		my.add(root);
		while(!my.isEmpty()) {
			BinaryTreeNode<Integer> front=my.poll();
			System.out.println("Enter the left data of "+front.data);
			int leftdata=s.nextInt();
			if(leftdata!=-1) {
				BinaryTreeNode<Integer> left=new BinaryTreeNode<>(leftdata);
				my.add(left);
				front.left=left;
			}

			System.out.println("Enter the right data of "+front.data);
			int rightdata=s.nextInt();
			if(rightdata!=-1) {
				BinaryTreeNode<Integer> right=new BinaryTreeNode<>(rightdata);
				my.add(right);
				front.right=right;
			}
		}
		return root;
	}
	
	public static void printLevelWiseBetter(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> my=new LinkedList<>();
		my.add(root);
		my.add(null);
		while(!my.isEmpty()) {
			BinaryTreeNode<Integer> front=my.poll();
			if(front!=null) {
				System.out.print(front.data+" ");
				if(front.left!=null) {
					my.add(front.left);
				}
				if(front.right!=null) {
					my.add(front.right);
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

		BinaryTreeNode<Integer> root=takeInputLevelWise();
		printLevelWiseBetter(root);
//		tripleReturn ans=isBSTbetter(root);
//		System.out.println(ans.isBst);
//		boolean ans=isBSTbest(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//		System.out.println(ans);
		
	}

}
