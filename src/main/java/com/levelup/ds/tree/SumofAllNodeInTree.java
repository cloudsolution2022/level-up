package com.levelup.ds.tree;

public class SumofAllNodeInTree {
    int index=-1;
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    public Node createBinaryTree(int [] inputEle){
        index++;
        System.out.println(index+":"+inputEle[index]);
        if(inputEle[index]==-1){
            return null;
        }
        Node currNode=new Node(inputEle[index]);
        currNode.left=createBinaryTree(inputEle);
        currNode.right=createBinaryTree(inputEle);
        return currNode;
    }
    public StringBuilder preOrderTraversal(Node root, StringBuilder sb,String padding, String pointer,Boolean hasRightChild)
    {
        if(root!=null){
            sb.append(padding);
            sb.append(pointer);
            sb.append(root.data);
            sb.append("\n");
            StringBuilder paddingBuilder=new StringBuilder(padding);
            if(hasRightChild){
                paddingBuilder.append("|  ");
            }else{
                paddingBuilder.append("  ");
            }
            String leftPointer="|_R_";
            String rightPointer=root.data>0?"|-L-":"|_L_";
            preOrderTraversal(root.left,sb,paddingBuilder.toString(),leftPointer,root.right!=null);
            preOrderTraversal(root.right,sb,paddingBuilder.toString(),rightPointer,false);
        }
        return sb;
    }

    public int sumOfAllNodeInTree(Node root){
         if(root==null){
             return 0;
         }
         int leftTreeSum=sumOfAllNodeInTree(root.left);
         int rightTreSum=sumOfAllNodeInTree(root.right);
         return leftTreeSum+rightTreSum+root.data;


    }

    public static void main(String [] args){
        System.out.println("Create binary tree");
        int []inputEle={1,2,4,-1,-1,5,-1,-1,8,-1,9,-1,10,-1,12,-1,-1};
        //int[] inputEle = {1, 7, 3, -1, -1, 4, -1, -1, 5, -1, 8, 6, -1, -1, 9, -1, -1};
        SumofAllNodeInTree sumofAllNodeInTree=new SumofAllNodeInTree();
        Node  root=sumofAllNodeInTree.createBinaryTree(inputEle);
        System.out.println("Print tree in DFS-PreOrder format");
        StringBuilder sb=new StringBuilder();
        sb=sumofAllNodeInTree.preOrderTraversal(root,sb,"","",false);
        System.out.println(sb);
        System.out.println("Sum Of all node in tree : "+sumofAllNodeInTree.sumOfAllNodeInTree(root));


    }
}
