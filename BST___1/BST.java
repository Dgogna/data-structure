package BST___1;
import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.BinaryTreeNode;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;
	
	private static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int left=minimum(root.left);
		int right=minimum(root.right);
		
		return Math.min(root.data, Math.min(left, right));
	}
	
	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
		if(node==null) {
			return false;
		}
		if(node.data==x) {
			return true;
		}
		if(x<node.data) {
			return isPresentHelper(node.left,x);
		}else {
			return isPresentHelper(node.right,x);
		}
	}
	public boolean isPresent(int x) {
		return isPresentHelper(root,x);	
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node , int x){
		if(node==null) {
			BinaryTreeNode<Integer> ans=new BinaryTreeNode<Integer>(x);
			return ans;
		}
		if(x>=node.data) {
			BinaryTreeNode<Integer> right=insertHelper(node.right, x);
			node.right=right;
		}else {
			BinaryTreeNode<Integer> left=insertHelper(node.left, x);
			node.left=left;
		}
		
		return node;		
	}
	public void insert(int x) {
		BinaryTreeNode<Integer> node=insertHelper(root,x);
		root=node;
		size++;
	}
	
	private static deleteDataHelper delData(BinaryTreeNode<Integer> root, int x) {
		if(root==null) {
			deleteDataHelper ans=new deleteDataHelper(null,false);
			return ans;
		}
		
		if(root.data<x) {
			deleteDataHelper outputRight=delData(root.right,x);
			root.right=outputRight.root;
//			outputRight.root=root;
//			return outputRight;
			return new deleteDataHelper(root,true);
		}
		if(root.data>x) {
			deleteDataHelper outputLeft=delData(root.left,x);
			root.left=outputLeft.root;
//			outputLeft.root=root;
//			return outputLeft;
			return new deleteDataHelper(root,true);
		}
		
		if(root.left==null && root.right==null) {
			return new deleteDataHelper(null,true);
		}
		if(root.left!=null && root.right==null) {
			return new deleteDataHelper(root.left,true);
		}
		if(root.left==null && root.right!=null) {
			return new deleteDataHelper(root.right,true);
		}
		
		// both children are present
		int rightMin=minimum(root.right);
		root.data=rightMin;
		deleteDataHelper outputRight=delData(root.right,rightMin);
		root.right=outputRight.root;
		return new deleteDataHelper(root,true);
	}
	public boolean deleteData(int x) {
		deleteDataHelper ans=delData(root,x);
		root=ans.root;
		if(ans.deleated) {
			size--;
		}
		return ans.deleated;
	}
	
	public int size() {
		return size;
	}
	
	private static void printHelper(BinaryTreeNode<Integer> node) {
		Queue<BinaryTreeNode<Integer>> my=new LinkedList<>();
		my.add(node);
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
	public void print() {
		printHelper(root);
	}
	
}
