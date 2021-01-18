package interview_camp;

import java.util.Objects;

public class Utils {


    public static class TreeNode<T> {
        private TreeNode<T> left;
        private TreeNode<T> right;

        private final T data;

        public TreeNode(T data) {
            this.data = data;
        }

        public TreeNode(TreeNode<T> left, TreeNode<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }


        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }


    }

    public static class Pair<T> {

        private final T x;
        private final T y;

        public Pair(T x, T y) {
            this.x = x;
            this.y = y;
        }

        public T getX() {
            return x;
        }

        public T getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return pair.getX().equals(x) && pair.getY().equals(y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
