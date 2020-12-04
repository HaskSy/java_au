# Design

+ [Binary Search Tree Iterator](#binary-search-tree-iterator)

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/
```java
class BSTIterator {

    TreeNode root;
    int index;
    List<TreeNode> flatTree = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        index = 0;
        this.root = root;
        flattening(root);
    }

    public int next() {

        TreeNode node = flatTree.get(index);
        index++;
        return node.val;
    }

    public boolean hasNext() {
        return index < flatTree.size();
    }

    private void flattening(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            flattening(root.left);
        }

        flatTree.add(root);

        if (root.right != null) {
            flattening(root.right);
        }
    }
}
```