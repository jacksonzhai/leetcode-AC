package bytecode.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMember;
import javassist.CtMethod;

public class JavassistTest {
    public static void main(String[] args)throws Exception {
        Base b = new Base();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("bytecode.javassist.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\");}");
        m.insertAfter("{System.out.println(\"end\");}");
        Class c = cc.toClass();
        cc.writeFile("E:\\SourceCode\\leetcode-AC");
        Base h = (Base) c.newInstance();
        h.process();

    }
}
