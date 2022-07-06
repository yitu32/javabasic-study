package com.yitu32.net.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName StreamUtil
 * @Author yitu32
 * @Description //
 * @Date 2022/7/4 17:25
 * @Version 1.0
 */
public class StreamUtils {

    // 从stream 中读取字节数组
    public static byte[] StreamToByteArray(InputStream inputStream) {
        ByteArrayOutputStream bos = null;
        byte[] buf = new byte[8192];
        int len = 0;
        byte[] bytes = null;
        try {
            bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }


    public static void closeStream(InputStream in, OutputStream out) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSocket(ServerSocket serverSocket, Socket socket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
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
