package com.levelup.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
public class CreateBinaryTree {
    int index = -1;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node buildBinaryTree(int[] inputArr) {
        index++;
        if (inputArr[index] == -1) {
            return null;
        }
        Node newNode = new Node(inputArr[index]);
        newNode.left = buildBinaryTree(inputArr);
        newNode.right = buildBinaryTree(inputArr);
        return newNode;
    }

    static StringBuilder preOrderTraversalWithPattern(Node node,
                                                      StringBuilder sb,
                                                      String padding,
                                                      String pointer,
                                                      Boolean hasRightChild) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);
            sb.append("\n");
            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightChild) {
                paddingBuilder.append("|  ");
            } else {
                paddingBuilder.append("  ");
            }
            String pointToLeftChild = "|--";
            String pointerToRightchild = "|__";
            preOrderTraversalWithPattern(node.left, sb, paddingBuilder.toString(), pointToLeftChild, node.right != null);
            preOrderTraversalWithPattern(node.right, sb, paddingBuilder.toString(), pointerToRightchild, false);
        }
        return sb;

    }

    static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + ",");

            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    static void inOrderTraversal(Node rootNode){
        if(rootNode==null){
            return;
        }
        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data+",");
        inOrderTraversal(rootNode.right);
    }

    static void postOrderTraversal(Node rootNode){
        if(rootNode==null){
            return;
        }
        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.print(rootNode.data+",");
    }
    static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!(q.isEmpty())){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        CreateBinaryTree binaryTree = new CreateBinaryTree();
        //int[] inputArr = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1};
        int []inputArr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        System.out.println("Building Binary tree from given input array");
        for (int j : inputArr)
            System.out.print(j + ",");
        Node rootNode = binaryTree.buildBinaryTree(inputArr);
        System.out.println("\nPreOrder tree traversal with format");
        StringBuilder sb = preOrderTraversalWithPattern(rootNode, new StringBuilder(), "", "", false);
        System.out.println(sb);
        System.out.println("\npreOrder tree traversal");
        preOrderTraversal(rootNode);
        System.out.println("\nInOrder tree traversal");
        inOrderTraversal(rootNode);

        System.out.println("\nPost Order tree traversal");
        postOrderTraversal(rootNode);

        System.out.println("\nLevel Order tree traversal");
        levelOrderTraversal(rootNode);
    }
}
