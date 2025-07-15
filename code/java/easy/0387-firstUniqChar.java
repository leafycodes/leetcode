class Solution {
    public int firstUniqChar(String s) {
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                    int flag=1;
                for(int j=0;j<n;j++)
                {
                    if(i!=j && s.charAt(i)==s.charAt(j))
                    {
                        flag=0;
                        break;
                    }
                   
                }
                if(flag==1)
                {
                    return i;
                }
               
            }
            return -1;
            
            
        }
    }
    
    //code seen from ratnesh_maurya for help

// faster way using queue
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDiam = diameterOfBinaryTree(root.left);
        int rDiam = diameterOfBinaryTree(root.right);
        int selfDiam = height(root.left) + height(root.right);

        return Math.max(Math.max(lDiam, rDiam), selfDiam);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
}