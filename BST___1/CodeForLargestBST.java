package BST___1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class CodeForLargestBST {
	
	public static largestBstReturn LargestBstHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return new largestBstReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
		}
		
		largestBstReturn leftOutput=LargestBstHelper(root.left);
		largestBstReturn rightOutput=LargestBstHelper(root.right);
		
		int minimum=Math.min(root.data,Math.min(leftOutput.min, rightOutput.min));;
		int maximum=Math.max(root.data,Math.max(leftOutput.max, rightOutput.max));
		int height=Math.max(leftOutput.height, rightOutput.height);
		if(leftOutput.isBST && rightOutput.isBST) {
			boolean isBST=true;
			if(root.data>leftOutput.max && root.data<rightOutput.min) {
				height=height+1;	
			}
			else {
				isBST=false;
				height=height;
			}
			return new largestBstReturn(minimum,maximum,isBST,height);
		}
		boolean isBST=false;
		return new largestBstReturn(minimum,maximum,isBST,height);
		

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		printLevelWiseBetter(root);
		
		System.out.println();
		System.out.println();
		largestBstReturn ans=LargestBstHelper(root);
		System.out.println(ans.height+" ");

	}

}
