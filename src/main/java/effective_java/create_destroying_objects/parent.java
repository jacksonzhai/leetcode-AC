package effective_java.create_destroying_objects;

import org.apache.commons.lang3.StringUtils;

public abstract class parent {
    abstract void doSomething();
    public static parent valueOf(String typ){
       if(StringUtils.equalsIgnoreCase(typ,"son")){
           return  new son();
       }else{
           return new girl();
       }
    }

}
