package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodesAtDistanceKFronNode {
	
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
	
	public static void NodesAtL(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
		}
		NodesAtL(root.left, k-1);
		NodesAtL(root.right, k-1);
	}
	
	public static int NodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		if(root==null) {
			return -1;
		}
		if(root.data==node) {
			NodesAtL(root, k);
			return 0;
		}
		
		int left=NodesAtDistanceK(root.left, node, k);
		if(left!=-1) {
			if(left+1==k) {
				System.out.println(root.data);
			}else {
				NodesAtL(root.right, k-left-2);
			}
			return left+1;
		}
		int right=NodesAtDistanceK(root.right, node, k);
		if(right!=-1) {
			if(right+1==k) {
				System.out.println(root.data);
			}else {
				NodesAtL(root.left, k-right-2);
			}
			return right+1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		NodesAtDistanceK(root,5,2);
		
	}
}
