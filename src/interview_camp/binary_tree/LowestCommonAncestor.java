package interview_camp.binary_tree;

import interview_camp.Utils;

public class LowestCommonAncestor {

    private static class Result<T> {
        boolean containsTarget;

        Utils.TreeNode<T> ancestor;
    }


    private static <T> Result<T> lcaAux(Utils.TreeNode<T> root, Utils.TreeNode<T> a, Utils.TreeNode<T> b) {
        if (root == null) {
            return new Result<>();
        }

        Result<T> leftResult = lcaAux(root.getLeft(), a, b);
        Result<T> rightResult = lcaAux(root.getRight(), a, b);

        if (leftResult.ancestor != null) {
            return leftResult;
        }

        if (rightResult.ancestor != null) {
            return rightResult;
        }

        // One each in a subtree
        if (rightResult.containsTarget && leftResult.containsTarget) {
            Result<T> result = new Result<>();
            result.ancestor = root;
            return result;
        }


        boolean subTreeContainsTarget = rightResult.containsTarget || leftResult.containsTarget;

        //Direct ancestor case
        if (subTreeContainsTarget && (root == a || root == b)) {
            Result<T> result = new Result<>();
            result.ancestor = root;
            return result;
        }

        boolean contains = rightResult.containsTarget || leftResult.containsTarget || root == a || root == b;

        Result<T> result = new Result<>();
        result.containsTarget = contains;

        return result;
    }

    /*
        LCA is the only node where both left and right subtree contains one of the nodes
     */
    private static <T> Utils.TreeNode<T> lca(Utils.TreeNode<T> root, Utils.TreeNode<T> a, Utils.TreeNode<T> b) {
        return lcaAux(root, a, b).ancestor;

    }

    public static void main(String[] args) {

    }
}
