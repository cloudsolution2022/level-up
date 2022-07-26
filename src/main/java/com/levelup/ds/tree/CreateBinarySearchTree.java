package com.levelup.ds.tree;

public class CreateBinarySearchTree {
   Node root=null;
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        public static Node createBinarySearchTree(int []inputArr){
            CreateBinarySearchTree bst=new CreateBinarySearchTree();
            Node node=bst.root;
            for(int i=0;i<inputArr.length;i++){
                System.out.print(inputArr[i]+" ");
                node=bst.insertElement(node, inputArr[i]);
            }
            return node;
        }
    private Node insertElement(Node node, int data) {
        //create  root node
        if(node ==null){
             return new Node(data);
        }
        //Add left child if input data < parent data
        if(data <= node.data){
            node.left=insertElement(node.left, data);
        }
        //Add right child if input data > parent data
        if(data > node.data){
            node.right=insertElement(node.right, data);
        }
        return node;
    }
    //PreorderTraversal = A-L-R
    public static void preOrderTraversal(Node node){
        if(node!=null){
            System.out.print(node.data+" ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    //InorderTraversal = L-A-R
    public static void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.left);
            System.out.print(node.data+" ");
            inOrderTraversal(node.right);
        }
    }
 public static void postOrderTraversal(Node node){
        if(node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data+" ");
        }
 }


    public static StringBuilder preOrderTraversalInTreePattern(Node node,StringBuilder sb,String paddingForBoth,String pointerForBoth,Boolean hasRightChild){
        if(node!=null){
            sb.append(paddingForBoth);
            sb.append(pointerForBoth);
            sb.append(node.data);
            sb.append("\n");
            StringBuilder paddingBuilder=new StringBuilder(paddingForBoth);
            if(hasRightChild){
                 paddingBuilder.append("|  ");
            }else{
                paddingBuilder.append("  ");
            }
            String pointerForRight="|_R_";
            String pointerForLeft=node.data>0?"|-L-":"|_L_";

            preOrderTraversalInTreePattern(node.left,sb,paddingBuilder.toString(),pointerForLeft,node.right!=null);
            preOrderTraversalInTreePattern(node.right,sb,paddingBuilder.toString(),pointerForRight,false);
        }
        return sb;

    }
  public static void main(String []args){
        System.out.println("Start creating binary search tree for:");
        int []inputElement={50,40,60,30,70,20,80,45,55,25,65};
        Node root= CreateBinarySearchTree.createBinarySearchTree(inputElement);
        System.out.println("\nPrint DFS-PreOrder in tree format");
        StringBuilder sb=preOrderTraversalInTreePattern(root,new StringBuilder(),"","",false);
        System.out.print(sb);
        System.out.println("\nPrint DFS-PreOrder tree traversal:");
        CreateBinarySearchTree.preOrderTraversal(root);
        System.out.println("\nPrint DFS-InOrder tree traversal");
        inOrderTraversal(root);
        System.out.println("\nPrint DFS-PostOrder tree traversal");
        postOrderTraversal(root);

    }
}
