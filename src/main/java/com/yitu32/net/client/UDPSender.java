package com.yitu32.net.client;

import com.yitu32.net.util.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

/**
 * @ClassName Socket_
 * @Author yitu32
 * @Description //
 * @Date 2022/7/4
 * @Version 1.0
 */
public class UDPSender {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            byte[] data = "我给你发了一条消息，你收到了吗".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("10.3.15.62"), 5555);
            datagramSocket.send(datagramPacket);

            byte[] buf = new byte[1024];
            // 数据包将会传到datagramPacket对象中  当有数据包发送到 本机的 5555 端口时，就会接收到数据，没有，就会阻塞等待
            datagramPacket = new DatagramPacket(buf, buf.length);
            System.out.println("消息发送成功，等待接收数据。。。。。。");
            datagramSocket.receive(datagramPacket);

            int length = datagramPacket.getLength();
            data = datagramPacket.getData();
            String content = new String(data, 0, length);
            System.out.println("收到消息，消息内容：["+content+"]");
            System.out.println("关闭。。。");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
