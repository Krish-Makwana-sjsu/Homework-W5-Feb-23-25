import java.util.List;
import java.util.LinkedList;

// Definition for a BST node
class TreeNode {
    int val;                    // Node value
    TreeNode left;              // left node
    TreeNode right;             // right node
}

// Class to make BST objects
class BST {
    TreeNode root;          // root of the tree

    BST() {
        root=null;
    }      // Constructor to initialize the root as null

    // Method to print BST (Sanity check)
    public void printBst(TreeNode node) {
        if(node==null) {
            return;
        }
        System.out.println(node.val);
        printBst(node.left);
        printBst(node.right);
    }

    // Method to add a value into a BST
    public void insert(int val) {

        // Create a new node and set its value
        TreeNode newNode=new TreeNode();
        newNode.val=val;

        // If the root is null, make the new node as the root and return
        if(root==null) {
            root=newNode;
            return;
        }

        // If root is present, traverse the BST to find appropriate position
        TreeNode curr=root;
        while(true) {
            // If value is less than current value, search in left. If empty spot found, insert the node, or else continue
            if(val<curr.val) {
                if(curr.left==null) {
                    curr.left=newNode;
                    return;
                }
                else {
                    curr=curr.left;
                }
            }
            // If value is more than current value, search in right. If empty spot found, insert the node, or else continue
            else {
                if(curr.right==null) {
                    curr.right=newNode;
                    return;
                }
                else {
                    curr=curr.right;
                }
            }
        }
    }


}

public class BSTprob {

    // Problem function: This method must search for the key k in a Binary Search Tree (BST) and return the search trace as a List<Integer>.
    public static List<Integer> bstSearchTrace(TreeNode root, Integer k) {

        // Make an empty linked list
        List<Integer> trace=new LinkedList<>();

        // If the tree is empty/root is null, return the empty linked list
        if(root==null) {
            return trace;
        }

        // Add the root's value to the linked list
        trace.add(root.val);

        // If the value to search is root, return the root appended linked list
        if(root.val==k) {
            return trace;
        }

        // If value to search is less than the root value, search in left subtree
        if(root.val > k) {
            List<Integer> leftList= bstSearchTrace(root.left, k);   // Recursively, get the traced linked list from left subtree

            // Append each element from left linked list into the trace (result linked list)
            for(int x: leftList) {
                trace.add(x);
            }

            return trace;       // Return the result linked list
        }

        // If value to search is more than the root value, search in right subtree
        else {
            List<Integer> rightList= bstSearchTrace(root.right, k);     // // Recursively, get the traced linked list from right subtree

            // Append each element from right linked list into the trace (result linked list)
            for(int x: rightList) {
                trace.add(x);
            }
            return trace;       // Return the result linked list
        }

    }

    // For my own use
    public static void main(String[] args) {

        // Create a BST and insert values
        BST bst=new BST();
        bst.insert(15);
        bst.insert(6);
        bst.insert(18);
        bst.insert(3);
        bst.insert(7);
        bst.insert(17);
        bst.insert(20);
        bst.insert(2);
        bst.insert(4);
        bst.insert(13);
        bst.insert(9);

        // Tracing the route of 13, and returning the traced linked list
        List<Integer> linkedList1=bstSearchTrace(bst.root, 13);

        // Printing the returned list (Sanity check)
        for(int x: linkedList1) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Tracing the route of 14 (does not exist in tree), and returning the traced linked list
        List<Integer> linkedList2=bstSearchTrace(bst.root, 14);

        // Printing the returned list (Sanity check)
        for(int x: linkedList2) {
            System.out.print(x + " ");
        }

    }
}
