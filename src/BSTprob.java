import java.util.List;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

class BST {
    TreeNode root;

    BST() {
        root=null;
    }

    public void printBst(TreeNode node) {
        if(node==null) {
            return;
        }
        System.out.println(node.val);
        printBst(node.left);
        printBst(node.right);
    }

    public void insert(int val) {

        TreeNode newNode=new TreeNode();
        newNode.val=val;

        if(root==null) {
            root=newNode;
            return;
        }

        TreeNode curr=root;
        while(true) {
            if(val<curr.val) {
                if(curr.left==null) {
                    curr.left=newNode;
                    return;
                }
                else {
                    curr=curr.left;
                }
            }
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

    public static List<Integer> bstSearchTrace(TreeNode root, Integer k) {

        List<Integer> trace=new LinkedList<>();
        if(root==null) {
            return trace;
        }

        trace.add(root.val);

        if(root.val==k) {
            return trace;
        }

        if(root.val > k) {
            List<Integer> leftList= bstSearchTrace(root.left, k);
            for(int x: leftList) {
                trace.add(x);
            }
            return trace;
        }
        else {
            List<Integer> rightList= bstSearchTrace(root.right, k);
            for(int x: rightList) {
                trace.add(x);
            }
            return trace;
        }

    }

    public static void main(String[] args) {

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

        List<Integer> linkedList1=bstSearchTrace(bst.root, 13);

        for(int x: linkedList1) {
            System.out.println(x + " ");
        }
        System.out.println();

        List<Integer> linkedList2=bstSearchTrace(bst.root, 14);
        for(int x: linkedList2) {
            System.out.println(x + " ");
        }

    }
}
