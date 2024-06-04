package Tree;

public class BinarySearchTree {

    private BinarySearchTree.TreeNode root;

    public class TreeNode {
        private BinarySearchTree.TreeNode left;
        private BinarySearchTree.TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void in_order(TreeNode root) {
        if (root == null) {
            return;
        }

        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    public TreeNode search(TreeNode root, int key) {
        if ((root == null) || (root.data == key)) {
            return root;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String... args) {
        BinarySearchTree tree = new BinarySearchTree();

        final double number = 1.001023012;

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);

        tree.in_order(tree.root);

        System.out.println();

        if (tree.search(3) != null) System.out.println("key found");
        else System.out.println("key not found");

        System.out.println();
    }
}
