

public class MyTree {

    private class TreeNode{

        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    public MyTree(){
        root = null;
    }

    public boolean contains(int val){
        return isInTree(val, root);
    }

    public boolean isInTree(int val, TreeNode root){

        if(root == null)
            return false;
        else if (root.val == val)
            return true;
        else if (root.val < val)
            return isInTree(root.val, root.right);
        else
            return isInTree(val, root.left);
    }

    public void add(int val){
        root = insertIntoTree(val, root);
    }

    public TreeNode insertIntoTree(int val, TreeNode node) {
        if(node == null)
            return new TreeNode(val, null, null);
        else if(node.val > val) {
            node.left = insertIntoTree(val, node.left);
            return node;
        }
        else {
            node.right = insertIntoTree(val, node.right);
            return node;
        }
    }

    public static void showTreeElems(TreeNode node){
        // inorder traversal
        // firstly traverse the left side
        // then output the root
        // thereafter traverse the right side
        if(node != null){
            showTreeElems(node.left);
            System.out.println(node.val+" ");
            showTreeElems(node.right);
        }
    }

    public void displayTree(){
        showTreeElems(root);
    }
}
