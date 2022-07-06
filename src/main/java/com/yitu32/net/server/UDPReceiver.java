package com.yitu32.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @ClassName ServerSocket_
 * @Author
 * @Description
 * @Date 2022/7/4
 * @Version 1.0
 */
public class UDPReceiver {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(5555);
            byte[] buf = new byte[1024];
            // 数据包将会传到datagramPacket对象中  当有数据包发送到 本机的 5555 端口时，就会接收到数据，没有，就会阻塞等待
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
            System.out.println("接收端启动成功，等待接收数据。。。。。。");
            datagramSocket.receive(datagramPacket);

            int length = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            String content = new String(data, 0, length);
            System.out.println("收到消息，消息内容：["+content+"]");

            data = "我收到你发的消息了".getBytes();
            datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("10.3.15.62"), 8888);
            datagramSocket.send(datagramPacket);
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
