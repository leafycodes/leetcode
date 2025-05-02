class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
                               int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }

        int leftChild = preorder[preStart + 1];

        int leftSubtreeSize = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == leftChild) {
                leftSubtreeSize = i - postStart + 1;
                break;
            }
        }

        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, 
                              postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, 
                               postorder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }
}