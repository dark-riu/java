package bean;

import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws Exception {
        DefientClassload load=new DefientClassload();
        Class c=Class.forName("bean.Cat",true,load);
        Object obj =c.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());  //查看这个对象的类装载器 com.MyClassLoader@6d06d69c

        Method m= c.getDeclaredMethod("speak");
        m.setAccessible(true);
        m.invoke(obj);
    }
}
