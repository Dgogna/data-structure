package binaryTrees;
import java.util.Scanner;


import linkedList_____1.Node;
import java.util.Queue;
import java.util.*;
import java.util.LinkedList;

public class BinaryTreeUse {

	public static void NodesAtK(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.print(root.data+" ");

		}
		NodesAtK(root.left,k-1);
		NodesAtK(root.right,k-1);

	}

	public static int distFromAncestors(BinaryTreeNode<Integer> root,int node , int k) {
		if(root==null) {
			return -1;
		}
		if(root.data==node) {
			NodesAtK(root,k);
			return 0;
		}

		int left=distFromAncestors(root.left,node,k);
		if(left!=-1) {
			if(left+1==k) {
				System.out.print(root.data+" ");
			}else {
				NodesAtK(root.right,k-left-2);
			}
			return 1+left;
		}

		int right=distFromAncestors(root.right,node,k);
		if(right!=-1) {
			if(right+1==k) {
				System.out.print(root.data+" ");
			}else {
				NodesAtK(root.left,k-right-2);
			}
			return 1+right;
		}

		return -1;
	}

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root,int node,int k) {

		int ans=distFromAncestors(root,node,k);

	}

	public static Pair<Integer,Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root==null){
			Pair<Integer,Integer> ans=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
			return ans;
		}
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		if(root.data>max){
			max=root.data;
		}
		if(root.data<min){
			min=root.data;
		}

		Pair<Integer, Integer> left=getMinAndMax(root.left);
		Pair<Integer, Integer> right=getMinAndMax(root.right);

		int maxfl=Math.max(root.data,Math.max(left.maximum,right.maximum));
		int minfl=Math.min(root.data,Math.min(left.minimum,right.minimum));
		Pair<Integer,Integer> ans=new Pair<>(minfl,maxfl);
		return ans;
	}

	public static BinaryTreeNode<Integer> constructFromInorderAndPostorderHelper(int in[], int post[],int siIn,int eiIn,int siPost,int eiPost){

		if(siIn>eiIn) {
			return null;
		}

		int front=post[eiPost];
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(front);

		int breakpoint=-1;
		for(int i=siIn;i<=eiIn;i++) {
			if(in[i]==front) {
				breakpoint=i;
				break;
			}
		}

		int small1SiIn=siIn;
		int small1EiIn=breakpoint-1;
		int small2SiIn=breakpoint+1;
		int small2EiIn=eiIn;
		int small1SiPost=siPost;
		int length=small1EiIn-small1SiIn+1;
		int small1EiPost=siPost+length-1;
		int small2SiPost=small1EiPost+1;
		int small2EiPost=eiPost-1;

		BinaryTreeNode<Integer> left=constructFromInorderAndPostorderHelper(in,post,small1SiIn,small1EiIn,small1SiPost,small1EiPost);
		BinaryTreeNode<Integer> right=constructFromInorderAndPostorderHelper(in,post,small2SiIn,small2EiIn,small2SiPost,small2EiPost);

		root.left=left;
		root.right=right;

		return root;

	}

	public static BinaryTreeNode<Integer> constructFromInorderAndPostorder(int in[], int post[]){
		BinaryTreeNode<Integer> root=constructFromInorderAndPostorderHelper(in,post,0,in.length-1,0,post.length-1);
		return root;
	}
	
	public static BinaryTreeNode<Integer> constructUsingPreorderAndInorder(int[] in, int[] pre,int siin, int eiin, int sipre, int eipre){
		if(siin>eiin) {
			return null;
		}
		int front=pre[sipre];
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(front);
		int inbreak=-1;
		for(int i=0;i<=eiin;i++) {
			if(in[i]==front) {
				inbreak=i;
				break;
			}
		}
		
		int in1=siin;
		int in2=inbreak-1;
		int in3=inbreak+1;
		int in4=eiin;
		int length=in2-in1+1;
		int pre1=sipre+1;
		int pre2=sipre+length-1;
		int pre3=pre2+1;
		int pre4=eipre;
		
		root.left=constructUsingPreorderAndInorder(in, pre, in1, in2, pre1, pre2);
		root.right=constructUsingPreorderAndInorder(in, pre, in3, in4, pre3, pre4);
		
		return root;
		
		
		
	}

	public static BinaryTreeNode<Integer> constructUsingPreorderAndInorder(int[] in, int[] pre){

		BinaryTreeNode<Integer> root=constructUsingPreorderAndInorder(in, pre, 0, in.length-1, 0, pre.length-1);
		
//		if(in.length==0) {
//			//BinaryTreeNode<Integer> my=new BinaryTreeNode<>(in[0]);
//			return null;
//		}
//
//		int first=pre[0];
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(first);
//		int inbreak=-1;
//		for(int i=0;i<in.length;i++) {
//			if(in[i]==first) {
//				inbreak=i;
//			}
//		}
//		int[] smallin=new int[inbreak];
//		for(int i=0;i<smallin.length;i++) {
//			smallin[i]=in[i];
//		}
//
//		int[] smallin2=new int[in.length-inbreak-1];
//		for(int i=0;i<smallin2.length;i++) {
//			smallin2[i]=in[i+inbreak+1];
//		}
//
//		int length=smallin.length;
//		int[] smallpre=new int[length];
//		for(int i=0;i<smallpre.length;i++) {
//			smallpre[i]=pre[i+1];
//		}
//
//		int length1=smallin2.length;
//		int[] smallpre2=new int[length1];
//		for(int i=0;i<smallpre2.length;i++) {
//			smallpre2[i]=pre[i+length+1];
//		}
//
//		BinaryTreeNode<Integer> left=constructUsingPreorderAndInorder(smallin,smallpre);
//		BinaryTreeNode<Integer> right=constructUsingPreorderAndInorder(smallin2,smallpre2);
//
//		root.left=left;
//		root.right=right;

		return root;

	}

	public static DiameterReturn diameterBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			int height=0;
			int dia=0;
			DiameterReturn ans=new DiameterReturn();
			ans.height=height;
			ans.diameter=dia;
			return ans;
		}

		DiameterReturn leftoutput=diameterBetter(root.left);
		DiameterReturn rightoutput=diameterBetter(root.right);

		int tempdia=leftoutput.height+rightoutput.height;

		int finaldia=Math.max(tempdia, Math.max(leftoutput.diameter, rightoutput.diameter));

		int dia=finaldia;
		int height=Math.max(leftoutput.height,rightoutput.height)+1;
		DiameterReturn ans=new DiameterReturn();
		ans.height=height;
		ans.diameter=dia;
		return ans;
	}

	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftheight=height(root.left);
		int rightheight=height(root.right);
		int rans=leftheight+rightheight;
		int left=diameter(root.left);
		int right=diameter(root.right);
		return Math.max(rans, Math.max(left, right));
	}

	public static BinaryTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			int height=0;
			boolean isbal=true;
			BinaryTreeReturn ans=new BinaryTreeReturn();
			ans.height=height;
			ans.isBalanced=isbal;
			return ans;
		}

		BinaryTreeReturn leftoutput=isBalancedBetter(root.left);
		BinaryTreeReturn rightoutput=isBalancedBetter(root.right);
		boolean isbal=true;

		if(Math.abs(leftoutput.height-rightoutput.height)>1) {
			isbal=false;
		}
		if(!leftoutput.isBalanced || !rightoutput.isBalanced) {
			isbal=false;
		}
		int height=Math.max(leftoutput.height,rightoutput.height)+1;
		BinaryTreeReturn ans=new BinaryTreeReturn();
		ans.height=height;
		ans.isBalanced=isbal;
		return ans;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int l=height(root.left);
		int r=height(root.right);

		return 1+Math.max(l, r);
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int lheight=height(root.left);
		int rheight=height(root.right);
		if(Math.abs(lheight-rheight)>1) {
			return false;
		}

		boolean l=isBalanced(root.left);
		boolean r=isBalanced(root.right);

		return l&&r;
	}

	public static void printLeafNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.data+",");
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left = removeLeafNodes(root.left);
		root.right = removeLeafNodes(root.right);

		return root;
	}

	public static int noOfNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}

		int l=noOfNodes(root.left);
		int r=noOfNodes(root.right);
		return l+r+1;

	}

	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isroot,int parentdata,boolean isleft) {
		if(isroot) {
			System.out.println("Enter the root data");
		}else{
			if(isleft) {
				System.out.println("Enter the left child of "+parentdata);
			}else {
				System.out.println("Enter the right child of "+parentdata);
			}
		}
		Scanner s=new Scanner(System.in);
		//	System.out.println("Enter the root data");
		int rootdata=s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);

		BinaryTreeNode<Integer> leftroot=takeTreeInputBetter(false,rootdata,true);
		BinaryTreeNode<Integer> rightroot=takeTreeInputBetter(false,rootdata,false);
		root.left=leftroot;
		root.right=rightroot;

		return root;
	}

	public static BinaryTreeNode<Integer> takeTreeInput() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootdata=s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootdata);

		BinaryTreeNode<Integer> leftroot=takeTreeInput();
		BinaryTreeNode<Integer> rightroot=takeTreeInput();
		root.left=leftroot;
		root.right=rightroot;

		return root;
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

	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left!=null) {
			System.out.print("L"+root.left.data+",");
		}
		if(root.right!=null) {
			System.out.print("R"+root.right.data);
		}
		System.out.println();
		print(root.left);
		print(root.right);
	}

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

	public static ArrayList<Node<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
		ArrayList<Node<Integer>> ans=new ArrayList<>();
		Queue<BinaryTreeNode<Integer>> my=new LinkedList<>();
		my.add(root);
		my.add(null);
		Node<Integer> head=null, tail=null;
		while(!my.isEmpty()){
			BinaryTreeNode<Integer> front=my.poll();
			Node<Integer> toadd;
			//	Node<Integer> toadd=new Node<>(front.data);
			if(head==null) {
				toadd=new Node(front.data);
				head=toadd;
				tail=head;
			}
			else if(head!=null && front!=null) {
				toadd=new Node(front.data);
				tail.next=toadd;
				tail=tail.next;
			}

			if(front!=null) {
				if(front.left!=null) {
					my.add(front.left);
				}
				if(front.right!=null) {
					my.add(front.right);
				}
			}
			
			if(front==null) {
				tail.next=null;
				ans.add(head);
				head=null;
				if(!my.isEmpty()) {
					my.add(null);
				}
			}
			
		}
		return ans;
	}
	
	public static void postorder(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BinaryTreeNode<Integer> root=takeTreeInput();
//		BinaryTreeNode<Integer> root=takeInputLevelWise();
		//		//BinaryTreeNode<Integer> root=takeTreeInputBetter(true ,0,false);
//		print(root);
//		postorder(root);
		
		//		printLevelWise(root);
		//		int nodes=noOfNodes(root);
		//		System.out.println("total nodes in the tree is "+nodes);
		//		System.out.print("the leaf nodes in the tree are ");
		//		printLeafNodes(root);
		//		System.out.println();
		////		BinaryTreeNode<Integer> removeleaf=removeLeafNodes(root);
		////		print(removeleaf);
		//		
		////		System.out.println(isBalanced(root));
		//		BinaryTreeReturn ans=isBalancedBetter(root);
		//		System.out.println("is Balanced "+ans.isBalanced);
		////		System.out.println("Diameter of the tree is "+diameter(root));
		//		DiameterReturn betterdia=diameterBetter(root);
		//		System.out.println("Diameter of the tree is "+betterdia.diameter);

				int in[]= {4,2,5,1,6,3,7};
				int pre[]= {1,2,4,5,3,6,7};
		//		int post[]= {4,5,2,6,7,3,1};
				BinaryTreeNode<Integer> root2=constructUsingPreorderAndInorder(in,pre);
		//		BinaryTreeNode<Integer> root2=constructFromInorderAndPostorder(in,post);
				printLevelWise(root2);

		//		Pair<Integer,Integer> mypair=getMinAndMax(root);
		//		System.out.println(mypair.maximum+"   "+mypair.minimum);
		//		printLevelWiseBetter(root);

		//int ans=distFromAncestors(root,5,2);
		//distFromAncestors(root,5,3);
		//		nodesAtDistanceK(root,3,3);
//				ArrayList<Node<Integer>> res=constructLinkedListForEachLevel(root);
//				for(Node<Integer> i:res) {
//					System.out.println(i.data);
//				}

	}

}
