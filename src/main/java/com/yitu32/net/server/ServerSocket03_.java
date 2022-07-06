package com.yitu32.net.server;

import com.yitu32.net.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerSocket_
 * @Author
 * @Description
 * @Date 2022/7/4
 * @Version 1.0
 */
public class ServerSocket03_ {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedOutputStream bos = null;
        InputStream inputStream = null;
        try {
            // 监听1030端口
            serverSocket = new ServerSocket(1030);
            System.out.println("服务端在1030端口等着你，不见不散哦。。。");
            // 代码会一致阻塞在这里，知道有客户端连接才会往下走，并返给客户端一个socket对象
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] bytes = StreamUtils.StreamToByteArray(inputStream);
            OutputStream outputStream = new FileOutputStream("e:\\test\\"+System.currentTimeMillis() + "_.png");
            bos = new BufferedOutputStream(outputStream);
            bos.write(bytes);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtils.closeStream(inputStream,bos);
            StreamUtils.closeSocket(serverSocket,socket);
        }

    }
}
