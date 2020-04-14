package bean;

import java.io.FileInputStream;
import java.io.InputStream;

public class DefientClassload extends ClassLoader{
    protected Class<?> findClass(String name){
        String filePath="C:\\Users\\niruoqingcheng\\Desktop\\Cat.class";
        try {
        InputStream in=new FileInputStream(filePath);
        byte []buff=new byte[in.available()];
        in.read(buff);
        in.close();
        Class<?>  c= this.defineClass(name,buff,0,buff.length);
        return c;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
