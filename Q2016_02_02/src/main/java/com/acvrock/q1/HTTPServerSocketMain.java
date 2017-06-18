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
                byte[] bytes = streamToByteArray(connection.getInputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write("HTTP/1.1 200 OK\r\nContent-Type:text/html;charset=UTF-8\r\n1111");
                outputStreamWriter.close();
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] streamToByteArray(InputStream stream) throws IOException {

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        int line = 0;
        // read bytes from stream, and store them in buffer
        while ((line = stream.read(buffer)) != -1) {
            // Writes bytes from byte array (buffer) into output stream.
            os.write(buffer, 0, line);
        }
        stream.close();
        os.flush();
        os.close();
        return os.toByteArray();
    }
}
