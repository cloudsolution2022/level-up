package com.levelup.ds.tree;

/**
 * Problem statement : https://leetcode.com/problems/range-sum-of-bst/
 * Example 1
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 * Constraint
 * its BST tree
 *
 *
 */
public class RangeSumofBST {
     public class Node{
         Node left;
         Node right;
         int data;
         Node(int data){
             this.data=data;
         }
     }
     public Node buildBST(Node node ,int data){
          if(node==null){
              return new Node(data);
          }

          if(data>node.data){
              node.right=this.buildBST(node.right,data);
          }

          if(data>node.data){
             node.left=this.buildBST(node.left,data);
         }
         return node;

     }
    public void preOrderTraversal(CreateBinaryTree.Node node){
        if(node!=null){
            System.out.println(node.data+",");
            this.preOrderTraversal(node.left);
            this.preOrderTraversal(node.right);
        }

    }
    public static void main(Strin []args){
         int []nodeElement= {10,5,15,3,7,-1,18};
         Node root=null;
         RangeSumofBST rangeSumofBST=new RangeSumofBST();
         for(int i=0;i<nodeElement.length;i++){
             rangeSumofBST.buildBST(root,nodeElement[i]);

         }


    }
}
