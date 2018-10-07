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
  
 public List<Integer> morrisPreOrderTree(TreeNode root){
       List<Integer> list = new LinkedList();
        TreeNode op = root;
        while(op != null){
            if(op.left == null){
                list.add(op.val);
                op = op.right;
            }
            else{
                TreeNode pre = op.left;
                while(pre.right != null && pre.right != op){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = op;
                    list.add(op.val);
                    op  = op.left;
                }
                else{
                    pre.right = null;
                    op = op.right;
                }
            }
        }
        return list;
        
    }

  }
 }
