package com.yitu32.net.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName Socket_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/4
 * @Version 1.0
 */
public class Socket01_ {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1025);
//            System.out.println("服务端返回：" + socket.getClass());
            outputStream = socket.getOutputStream();
            System.out.println("给服务端发送消息，消息内容是：hello,world");
            outputStream.write("hello,world".getBytes());
            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            System.out.println("接收服务端发来的消息：");
            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
