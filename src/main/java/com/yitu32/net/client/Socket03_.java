package com.yitu32.net.client;

import com.yitu32.net.util.StreamUtils;

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
public class Socket03_ {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1030);
            // 把文件从本地读到byte数组中
            bis = new BufferedInputStream(new FileInputStream("E:\\test\\20220101143216.png"));
            byte[] bytes = StreamUtils.StreamToByteArray(bis);
            // 通过输出流写出去
            bos = new BufferedOutputStream(socket.getOutputStream());
            bos.write(bytes);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtils.closeStream(bis,bos);
            StreamUtils.closeSocket(null,socket);
        }

    }
}
