package trees;

import java.util.ArrayList;

public class TreesTest {

    public static TreeNode addNodeToTree(TreeNode head, int data) {
        if (head == null) {
            head = new TreeNode();
            head.data = data;
            return head;
        }
        if (head.data < data) {
            head.right = addNodeToTree(head.right, data);
        } else {
            head.left = addNodeToTree(head.left, data);
        }
        return head;
    }

    public static ArrayList<Integer> inOrderTraversal(TreeNode head, ArrayList<Integer> arrayList) {
        TreeNode temp = head;
        if (temp != null) {
            inOrderTraversal(temp.left, arrayList);
            arrayList.add(temp.data);
            inOrderTraversal(temp.right, arrayList);
        }
        return arrayList;
    }

    public static ArrayList<Integer> printAllLeafNodes(TreeNode head, ArrayList<Integer> arrayList) {
        TreeNode temp = head;
        if (temp == null)
            return arrayList;

        if (temp.left == null && temp.right == null) {
            arrayList.add(temp.data);
        }
        if (temp.left != null) {
            printAllLeafNodes(temp.left, arrayList);
        }
        if (temp.right != null) {
            printAllLeafNodes(temp.right, arrayList);
        }
        return arrayList;
    }

}
