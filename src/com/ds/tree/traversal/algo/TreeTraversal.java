package com.ds.tree.traversal.algo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.leftNode = new Node(2);
		bt.root.leftNode.leftNode = new Node(4);
		bt.root.rightNode= new Node(3);
		bt.root.leftNode.rightNode = new Node(5);
		System.out.println("Input 1 (r) -> 2 (l), 3(r) ; 2-> 4(l), 5(r)" );
		System.out.println("************InOrder Travesal ******************");
		bt.inOrderTravesal(bt.root);
		System.out.println("\n************PreOrder Travesal ******************");
		bt.preOrderTravesal(bt.root);
		System.out.println("\n************PostOrder Travesal ******************");
		bt.postOrderTravesal(bt.root);
		System.out.println("\n************ Level order Travesal ******************");
		System.out.println(bt.breathFirstTraversal(bt.root));


	}


}

class Node{
	int key;
	Node leftNode, rightNode;
	public Node(int item) {
		key = item;
		leftNode = rightNode = null;
	}
}

class BinaryTree{
	Node root;
	public BinaryTree() {
		root = null;
	}
	// [1] Level order / Breath First traversal
	
	// Left sub tree-> Root -> Right sub tree
	public void inOrderTravesal(Node node) {

        if (node == null)
            return;
        
		inOrderTravesal(node.leftNode);
		System.out.print(node.key +", ");
		inOrderTravesal(node.rightNode);
	}
	// Root -> Left sub tree -> Right sub tree
	public void preOrderTravesal(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.key+", ");
		preOrderTravesal(node.leftNode);
		preOrderTravesal(node.rightNode);
	}
	// Left sub tree -> Right sub tree -> Root
	public void postOrderTravesal(Node node) {
		if(node == null) {
			return;
		}
		postOrderTravesal(node.leftNode);
		postOrderTravesal(node.rightNode);
		System.out.print(node.key+", ");
	}
	
	
	// [2] Level order / Breath First traversal
	public ArrayList<ArrayList<Integer>> breathFirstTraversal(Node node){
		ArrayList<ArrayList<Integer>> response =  new ArrayList<ArrayList<Integer>>();
		if(node == null)
			return response;

		Queue<Node> qNode = new LinkedList<Node>();
		/*
		boolean offer(E e)
		Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions. When using a capacity-restricted queue, this method is generally preferable to add(E), which can fail to insert an element only by throwing an exception.
		Parameters:e - the element to addReturns:true if the element was added to this queue, else false
		 */
		qNode.offer(node);
		qNode.offer(null);

		ArrayList<Integer> current =  new ArrayList<Integer>();
		/*
		boolean isEmpty()
		Returns true if this collection contains no elements.
		Returns:true if this collection contains no elements
		 */

		while(!qNode.isEmpty()) {
			Node temp = qNode.poll();
		/*
		E poll()
		Retrieves and removes the head of this queue, or returns null if this queue is empty.
		Returns:the head of this queue, or null if this queue is empty
	    */

			if(temp != null) {
				current.add(temp.key);
				if(temp.leftNode != null) {
					qNode.offer(temp.leftNode);
				}
				if(temp.rightNode != null) {
					qNode.offer(temp.rightNode);
				}
			}else {
				ArrayList<Integer> c_curr = new ArrayList<Integer>(current);
				response.add(c_curr);
				current.clear();
			 /*
			 public void clear()
			 Removes all of the elements from this list. The list will be empty after this call returns.
			 */
				if(!qNode.isEmpty())
					qNode.offer(null);
			}
		}
		return response;
	}
}