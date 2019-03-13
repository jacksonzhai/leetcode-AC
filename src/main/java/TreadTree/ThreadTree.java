package TreadTree;

public class ThreadTree {
    private ThreadNode root;
    private int size;
    private ThreadNode pre;

    public ThreadTree() {
        this.root = null;
        this.size = 0;
        this.pre = null;

    }

    public ThreadTree(int[] data) {
        this.pre = null;
        this.size = data.length;
        this.root  = createTree(data,1);

    }


    public ThreadNode createTree(int[] data, int index) {
        if (index > data.length) {
            return null;

        }
        ThreadNode node = new ThreadNode(data[index - 1]);
        ThreadNode left = createTree(data, 2 * index);
        ThreadNode right = createTree(data, 2 * index + 1);
        node.setLeft(left);
        node.setRight(right);
        return node;

    }
    public void initThread(ThreadNode root){
        if(root!= null){
            initThread(root.getLeft());
            if(null == root.getLeft()){
                root.setLTag(true);
                root.setLeft(pre);
            }
            if(pre!=null&&null == pre.getRight()){
                pre.setRTag(true);
                pre.setRight(root);
            }
            pre = root;
            initThread(root.getRight());
        }
    }

}
