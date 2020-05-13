package com.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 序号${}
 *
 * @author menggy
 * @date 2020/5/13 10:11
 */
public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8085);
        //阻塞
        while (true) {


            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println(request);
                out.println(request);
                if ("Done".equals(request)) {
                    break;
                }

            }
        }
    }

}
