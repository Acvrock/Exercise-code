package com.acvrock.q1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by moon on 22/02/2017.
 *
 * @Description:
 */
public class HTTPServerSocketMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1216);
            while (true) {
                Socket connection = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                System.out.println(bufferedReader.readLine());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write("HTTP/1.1 200 OK\nContent-Type:text/html;charset=UTF-8\n\n😄😄😄");
                outputStreamWriter.close();
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
