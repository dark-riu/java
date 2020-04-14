package com;

import java.io.*;
import java.net.Socket;

public class NewServerThread implements Runnable{
    Socket socket;
    public NewServerThread(Socket socket) {
        this.socket = socket;
    }
    File f=new File("C:\\Users\\niruoqingcheng\\Desktop\\downloadfiles");
    String str="";
    private String FileName(File f){
        File [] fileNameList=f.listFiles();

        for(File name:fileNameList) {
            if(name.isDirectory()){
                FileName(name);
            }
            else {
                str=str+name.getName()+" ";
            }
        }
        return str;
    }
    public void run() {
        System.out.println("已连接");
        String str=FileName(f);
        try {

        OutputStream out=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(out,true);
        pw.println(str);

        InputStream in=socket.getInputStream();
        byte [] buff=new byte[1024];
        int len=in.read(buff);
        String fileName=new String(buff,0,len);

        FileInputStream file=new FileInputStream("C:\\Users\\niruoqingcheng\\Desktop\\downloadfiles\\"+fileName);
        while ((len=file.read(buff))!=-1){
            out.write(buff,0,len);
        }
        socket.shutdownOutput();
        file.close();
        socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
