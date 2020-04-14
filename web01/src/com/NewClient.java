package com;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NewClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7890);
        InputStream in=socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        System.out.println("服务端可下载的列表如下");
        System.out.println("服务端上的文件列表"+br.readLine());
        System.out.println("输入要下载的文件名");
        String fileName=new Scanner(System.in).nextLine();
        OutputStream out=socket.getOutputStream();
        out.write(fileName.getBytes());
        socket.shutdownOutput();
        FileOutputStream file=new FileOutputStream("C:\\Users\\niruoqingcheng\\Desktop\\download\\"+fileName);
        byte []buff=new byte[1024];
        int len=0;
        while ((len=in.read())!=-1){
            file.write(buff,0,len);
        }
        System.out.println("下载成功");
        file.close();
        socket.close();
        out.close();
        br.close();
    }
}
