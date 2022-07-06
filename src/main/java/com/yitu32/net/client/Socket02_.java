package com.yitu32.net.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName Socket_
 * @Author yitu32
 * @Description //
 * @Date 2022/7/4
 * @Version 1.0
 */
public class Socket02_ {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1030);
//            System.out.println("服务端返回：" + socket.getClass());
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("给服务端发送消息，消息内容是：hello,这个世界真奇妙");
            // 用字符流来写
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("hello,这个世界真奇妙");
            // 增加一个换行符
            bufferedWriter.newLine();
            // 必须要把消息刷出去
            bufferedWriter.flush();

            InputStream inputStream = socket.getInputStream();
            // 用字符流来读
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String content = bufferedReader.readLine();
            System.out.println("接收服务端发来的消息：" + content);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
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
