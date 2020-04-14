package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(7890);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new NewServerThread(clientSocket)).start();
        }
    }
}
