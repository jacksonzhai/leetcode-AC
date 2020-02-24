package effective_java.create_destroying_objects;

public class Elvis2 {
    private static final Elvis2 instance = new Elvis2();
    private Elvis2(){}
    public static Elvis2 getInstance()
    {
        return instance;
    }
    public void leaveTheBuiling(){}

}

