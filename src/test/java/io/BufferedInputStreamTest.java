package io;

import java.io.*;

/**
 * @Author: majunsheng
 * @Date: 2018/12/13
 **/
public class BufferedInputStreamTest {

    public static void main(String[] args) {

        try {
            BufferedInputStream bs =
                    new BufferedInputStream(new FileInputStream(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
