package Tree;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root; // корень дерева

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void create_binary_tree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(11);

        root = first;
        first.left = second;
        first.right = third;
    }

    // ---- обход дерева PreOrder ---- //
    public void pre_order(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        pre_order(root.left);
        pre_order(root.right);
    }

    // ---- итеративный обход (Iterative Preorder traversal of a Binary Tree in Java) ---- ///
    public void iterative_pre_order(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }


    // ---- рекурсивный обход дерева по порядку (Recursive Inorder traversal of Binary Tree in Java) ---- ///
    public void in_order(TreeNode root) {
        if (root == null) return;

        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    public void iterative_in_order(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void post_order(TreeNode root) {
        if (root == null) {
            return;
        }

        pre_order(root.left);
        pre_order(root.right);
        System.out.println(root.data + " ");
    }

    public int find_max_value(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int result = root.data;
        int left = find_max_value(root.left);
        int right = find_max_value(root.right);

        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }

        return result;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.create_binary_tree();
        tree.pre_order(tree.root);
        System.out.println();
        tree.in_order(tree.root);
        System.out.println();
        tree.post_order(tree.root);
        System.out.println();
        System.out.println(tree.find_max_value(tree.root));
    }
}
