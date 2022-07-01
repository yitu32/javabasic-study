package com.yitu32.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName BufferedIOStream_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1 15:49
 * @Version 1.0
 */
public class BufferedIOStream_ {

    @Test
    public void test01() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String src = "e:\\test\\20220101143216.png";
        String dest = "e:\\test\\20220101143216_copy.png";
        byte[] buf = new byte[8192];
        int readLen = 0;
        try {
            long begin = System.currentTimeMillis();
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));
            while ((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }
            System.out.println("over.....cost:" + (System.currentTimeMillis() - begin));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
