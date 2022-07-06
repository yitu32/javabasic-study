package com.yitu32.net.server;

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
public class ServerSocket02_ {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // 监听1025端口
            serverSocket = new ServerSocket(1030);
            System.out.println("服务端在1030端口等着你，不见不散哦。。。");
            // 代码会一致阻塞在这里，知道有客户端连接才会往下走，并返给客户端一个socket对象
            socket = serverSocket.accept();
            // System.out.println("服务端accept产生的socket:"+socket.getClass());
            InputStream inputStream = socket.getInputStream();
            // 转换成字符流来读取
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String content = bufferedReader.readLine();
            System.out.println("收到客户端发来的消息：" + content);
            OutputStream outputStream = socket.getOutputStream();
            // 转换成字符流来写入
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            System.out.println("给服务端发送消息，消息内容是：你怎么知道的,client");
            bufferedWriter.write("你怎么知道的,client");
            bufferedWriter.newLine();
            // 必须要flush
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
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
