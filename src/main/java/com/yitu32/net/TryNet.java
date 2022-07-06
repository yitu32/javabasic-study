package com.yitu32.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName TryNet
 * @Author yitu32
 * @Description
 * @Date 2022/7/4
 * @Version 1.0
 */
public class TryNet {

    @Test
    public void test01(){
        try {
            InetAddress addresses = InetAddress.getByName("www.baidu.com");
            System.out.println(addresses);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
