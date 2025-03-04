import java.util.LinkedList;
import java.util.Queue;
public class GFG {

    /* A binary tree node has key, pointer to  
    left child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;

        // constructor 
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }

    /*function to insert element in binary tree */
    static void insert(Node temp, int key)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        Node newNode = new Node(key);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode.left==null) currNode.left=newNode;
            else queue.offer(temp.left);
            if(currNode.right==null) currNode.right=newNode;
            else queue.offer(temp.right);
        }
        // Do level order traversal until we find 
        // an empty place and add the node.  
    }

    // Driver code 
    public static void main(String args[])
    {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print( "Inorder traversal before insertion:");
        inorder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);
    }
}


/*
 *  Time Complexity: O(N) for insertion as we need to traverse through the entire list to add a new element
 *  Space Complexity: O(N) to store all the node information.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Simply traverse through all the node from the head to the last and append the next element.
 */
