/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class MorrisTraversalTree {
     public List<Integer> morrisInorderTree(TreeNode root){
        List<Integer> list = new LinkedList<>();
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                list.add(current.val);
                current = current.right;
            }
            else{
                TreeNode pre = current.left;
                while (pre.right!=null&&pre.right!=current){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = current;
                    current = current.left;
                }
                else{
                    pre.right = null;
                    list.add(current.val);
                    current = current.right;
                }

            }


        }
        return list;
     }
 }
