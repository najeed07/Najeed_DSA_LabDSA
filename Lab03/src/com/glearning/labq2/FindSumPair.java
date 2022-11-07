package com.glearning.labq2;
import java.util.*;

public class FindSumPair {

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	public Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		
		if(root==null) {
			return false;
		}
		
		if(findpairUtil(root.leftNode, sum, set)) {
			return true;
		}
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Pair is found "+(sum-root.nodeData)+","+root.nodeData);
			return true;
		}
		else {
			set.add(root.nodeData);
			return findpairUtil(root.rightNode, sum, set);
			}
	}
 
	public void findPairWithGivenSum(Node root, int sum){
		HashSet<Integer> set = new HashSet<>();
		if(!findpairUtil(root, sum, set)) {
			System.out.println("Pairs do not exist");
		}
		return;
		
	}

	// Driver code
	public static void main(String[] args)
	{
		Node root = null;
		
		FindSumPair findSP = new FindSumPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		int sum = 120;
		findSP.findPairWithGivenSum(root, sum);
	}

}
