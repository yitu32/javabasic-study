package com.yitu32.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerSocket_
 * @Author
 * @Description
 * @Date 2022/7/4
 * @Version 1.0
 */
public class ServerSocket01_ {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 监听1025端口
            serverSocket = new ServerSocket(1025);
            System.out.println("服务端在1025端口等着你，不见不散哦。。。");
            // 代码会一致阻塞在这里，知道有客户端连接才会往下走，并返给客户端一个socket对象
            socket = serverSocket.accept();
//            System.out.println("服务端accept产生的socket:"+socket.getClass());
            inputStream = socket.getInputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            System.out.println("收到客户端发来的消息：");
            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
            // 回消息给客户端
            System.out.println("给客户端回消息后退出，消息内容是：hello,boy");
            outputStream = socket.getOutputStream();
            outputStream.write("hello,boy".getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
