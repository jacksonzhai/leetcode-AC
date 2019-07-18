import java.util.List;

public class General {
    public static void foo(List<? extends  Number> l){
        l.add(null);
    }
    public static void bar(List<? super Number> l){
        l.add(new Integer(2));
        l.add(new Float(2));
    }
    public static <E> void test(List<E> l){
        E e = l.get(0);
        l.set(0,e);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
