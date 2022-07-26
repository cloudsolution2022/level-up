package com.levelup.ds.tree;

public class CountNodeInTree {
    int index = -1;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insertNode(int[] inputArr) {
        index++;
        if (inputArr[index] == -1) {
            return null;
        }
        int data = inputArr[index];
        Node curNode = new Node(data);
        curNode.left = insertNode(inputArr);
        curNode.right = insertNode(inputArr);
        return curNode;
    }

    public static Node createBinaryTree(int[] inputElement) {
        if (inputElement.length == 0) {
            return null;
        }
        CountNodeInTree numberOfNodeInTree = new CountNodeInTree();
        for (int i = 0; i < inputElement.length; i++) {
            System.out.print(inputElement[i] + " ");//passing element to build binary tree
        }
        return numberOfNodeInTree.insertNode(inputElement);
    }

    public static StringBuilder preOrderTraversalTreeFormat(Node root, StringBuilder sb, String padding, String pointer, Boolean hasRightChild) {
        if (root != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(root.data);
            sb.append("\n");
            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightChild) {
                paddingBuilder.append("| ");
            } else {
                paddingBuilder.append(" ");
            }
            String leftPointer = "|-L-";
            String rightPointer = "|-R-";
            preOrderTraversalTreeFormat(root.left, sb, paddingBuilder.toString(), leftPointer, root.right != null);
            preOrderTraversalTreeFormat(root.right, sb, paddingBuilder.toString(), rightPointer, false);
        }
        return sb;
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ,");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static int countNumberOfNodeInBinaryTree(Node node) {
        if (node == null) {
            return 0;
        }
        int leftCount = countNumberOfNodeInBinaryTree(node.left);
        int rightCount = countNumberOfNodeInBinaryTree(node.right);

        return leftCount + rightCount + 1;

    }

    public static void main(String[] args) {
        System.out.println("Create Binary tree from input array");
        //int []inputEle={1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1};
        int[] inputEle = {1, 7, 3, -1, -1, 4, -1, -1, 5, -1, 8, 6, -1, -1, 9, -1, -1};
        Node root = CountNodeInTree.createBinaryTree(inputEle);
        System.out.println("\nPrint DFS-preOrder traversal of tree");
        StringBuilder sb = new StringBuilder();
        sb = CountNodeInTree.preOrderTraversalTreeFormat(root, sb, "", "", false);
        System.out.println(sb);
        CountNodeInTree.preOrderTraversal(root);
        int numberOfNode = countNumberOfNodeInBinaryTree(root);
        System.out.println("\nTotal Number Of Node in tree:" + numberOfNode);
    }
}

