package interview_camp.binary_tree;

import interview_camp.Utils;

public class PrintPaths {


    private static <T> void printPathsAux(Utils.TreeNode<T> root, String prefix) {
        String newPrefix = prefix + root.getData();

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(newPrefix);
            return;
        }

        if (root.getLeft() != null) {
            printPathsAux(root.getLeft(), newPrefix);
        }

        if (root.getRight() != null) {
            printPathsAux(root.getRight(), newPrefix);
        }
    }

    private static <T> void printPaths(Utils.TreeNode<T> root) {
        printPathsAux(root, "");
    }


    /*
                        a
                    b       c
                  d        e  f
     */
    public static void main(String[] args) {

        Utils.TreeNode<String> a = new Utils.TreeNode<>("a");
        Utils.TreeNode<String> b = new Utils.TreeNode<>("b");
        Utils.TreeNode<String> c = new Utils.TreeNode<>("c");
        Utils.TreeNode<String> d = new Utils.TreeNode<>("d");
        Utils.TreeNode<String> e = new Utils.TreeNode<>("e");
        Utils.TreeNode<String> f = new Utils.TreeNode<>("f");

        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);

        c.setLeft(e);
        c.setRight(f);

        printPaths(a);
    }
}
