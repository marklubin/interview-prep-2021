package interview_camp.binary_tree;

import interview_camp.Utils;

import java.util.LinkedList;

import static interview_camp.Utils.*;

public class BasicTraversals {


    private static <T> void inOrder(Utils.TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());
    }


    private static <T> void preOrder(Utils.TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static <T> void postOrder(Utils.TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getData());
    }


    private static <T> void levelOrder(TreeNode<T> root) {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<T> current = queue.removeFirst();
                if (current.getLeft() != null) {
                    queue.addLast(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.addLast(current.getRight());
                }
                System.out.println(current.getData());
            }
        }
    }


    private static <T> void inorderIterative(TreeNode<T> root) {

    }


    /*
                    5
                       9
                   12    8
                        7
     */
    public static void main(String[] args) {
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> twelve = new TreeNode<>(12);
        TreeNode<Integer> eight = new TreeNode<>(8);
        TreeNode<Integer> nine = new TreeNode<>(9);
        TreeNode<Integer> five = new TreeNode<>(5);

        five.setRight(nine);
        nine.setLeft(twelve);
        nine.setRight(eight);
        eight.setLeft(seven);

        System.out.println("Inorder"); // 5 12 9 8 7
        inOrder(five);

        System.out.println("Preorder"); // 5 9 12 8 7
        preOrder(five);

        System.out.println("Postorder"); //12 7 8 9 5
        postOrder(five);

        System.out.println("Level Order"); //5 9 12 8 7
        levelOrder(five);

    }

}
