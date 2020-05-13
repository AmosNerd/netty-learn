package com.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 序号${}
 *
 * @author menggy
 * @date 2020/5/13 10:31
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8085);
        Scanner scanner = null;
        OutputStream os = null;
        scanner = new Scanner(System.in);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String in = "";
            do {
                out.println(scanner.next());
            } while (!in.equals("Done"));

        } finally {
            scanner.close();
            if (os != null) {
                os.close();
            }
        }


    }
}
