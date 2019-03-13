package TreadTree;

public class ThreadNode {
    private  int val;
    private ThreadNode left;
    private ThreadNode right;
    private  boolean LTag;
    private  boolean RTag;

    public ThreadNode(int val){
        this.val = val;
    }
    public int getVal() {
        return val;
    }

    public void setLeft(ThreadNode left) {
        this.left = left;
    }

    public void setLTag(boolean LTag) {
        this.LTag = LTag;
    }

    public void setRight(ThreadNode right) {
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setRTag(boolean RTag) {
        this.RTag = RTag;
    }

    public ThreadNode getLeft() {
        return left;
    }

    public ThreadNode getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+ this.val;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ThreadNode){
            if(((ThreadNode) obj).getVal() == this.val){
                return true;

            }
            return false;
        }
        return false;
    }
}
