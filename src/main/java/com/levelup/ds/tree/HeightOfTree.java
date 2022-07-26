package com.levelup.ds.tree;

public class HeightOfTree {
    int index=-1;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left= null;
            this.right=null;
        }

    }
    // int []inputEle={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    public Node createBinaryTree(int []inputEle){
        index++;
        if(inputEle[index]==-1){
            return null;
        }
        Node currNode=new Node(inputEle[index]);
        currNode.left=createBinaryTree(inputEle);
        currNode.right=createBinaryTree(inputEle);
        return currNode;
    }
     public StringBuilder preOrderTree(Node root,StringBuilder sb,String padding,String pointer, Boolean hasRightChild){

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
            String leftChildPointer="├──";
            String rightChildPointer="└──";
            preOrderTree(root.left,sb,paddingBuilder.toString(),leftChildPointer,root.right!=null);
            preOrderTree(root.right,sb,paddingBuilder.toString(),rightChildPointer,false);

        }
         return sb;
     }

    public static void main(String [] args){
        System.out.println("Create binary tree from give input array");
        int []inputEle={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //int []inputEle={1,2,4,5,6,-1,7,-1,8,-1,9,-1,-1,10,-1,11,-1,12,-1,-1};
        HeightOfTree heightOfTree=new HeightOfTree();
        Node root=heightOfTree.createBinaryTree(inputEle);
        System.out.println("Show Tree in DFS preOrder Format");
        StringBuilder sb=heightOfTree.preOrderTree(root,new StringBuilder(),"","",false);
        System.out.println(sb);

    }

}
