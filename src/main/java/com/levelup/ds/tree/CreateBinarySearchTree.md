<html>
    <h1>Create and travers Binary Search Tree</h1>
<br>Definition:</br>
Binary Search Tree is a node-based binary tree data structure which has the following properties:
<ul>
<li>The left subtree of a node contains only nodes with keys lesser than the node’s key.
<li>The right subtree of a node contains only nodes with keys greater than the node’s key.
<li>The left and right subtree each must also be a binary search tree.
</ul>
<p1>
inputElement:
<br>{50,40,60,30,70,20,80,45,55,25,65};
<br>Output :
<br>Print DFS-PreOrder tree traversal:
50 40 30 20 25 45 60 55 70 65 80 
Print DFS-InOrder tree traversal
20 25 30 40 45 50 55 60 65 70 80 
Print DFS-PostOrder tree traversal
25 20 30 45 40 55 65 80 70 60 50 
50
|--40
|  |--30
|  |  |--20
|  |    |__25
|  |__45
|__60
|--55
|__70
|--65
|__80
</p1>
</html>

