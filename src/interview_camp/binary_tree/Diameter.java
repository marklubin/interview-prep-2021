package interview_camp.binary_tree;

import interview_camp.Utils;

public class Diameter {

    private static int diameter = 0;


    private static <T> int maxHeight(Utils.TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxHeight(root.getLeft());
        int rightHeight = maxHeight(root.getRight());

        int localDiameter = leftHeight + rightHeight + 1;

        if (localDiameter > diameter) {
            diameter = localDiameter;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }

    private static <T> int calculateDiameter(Utils.TreeNode<T> root) {
        maxHeight(root);
        return diameter;
    }


    /*
                    a
              b            c
         g               e     f
                       h
     */
    public static void main(String[] args) {
        Utils.TreeNode<String> a = new Utils.TreeNode<>("a");
        Utils.TreeNode<String> b = new Utils.TreeNode<>("b");
        Utils.TreeNode<String> c = new Utils.TreeNode<>("c");
        Utils.TreeNode<String> d = new Utils.TreeNode<>("d");
        Utils.TreeNode<String> e = new Utils.TreeNode<>("e");
        Utils.TreeNode<String> f = new Utils.TreeNode<>("f");
        Utils.TreeNode<String> g = new Utils.TreeNode<>("g");
        Utils.TreeNode<String> h = new Utils.TreeNode<>("h");


        a.setRight(b);
        a.setLeft(c);

        b.setLeft(g);

        c.setLeft(e);
        c.setRight(f);

        e.setLeft(h);

        System.out.println(calculateDiameter(a));


    }
}
