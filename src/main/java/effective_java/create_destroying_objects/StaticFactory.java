package effective_java.create_destroying_objects;

import java.util.HashMap;
public class StaticFactory {
    public static Boolean valueOf(boolean b){
        return b?Boolean.TRUE:Boolean.FALSE;
    }

    public static void main(String[] args) {
        parent.valueOf("son").doSomething();
        parent.valueOf("g").doSomething();
    }
}
