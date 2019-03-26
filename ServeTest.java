package com.qf.javaday1.demo2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: YangRuiGuang
 * @Date: 2019/3/25 11:55
 */
public class ServeTest {
    public static void main(String[] args) throws IOException {

        Scanner input=new Scanner(System.in);
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("服务器正在连接");

        //监听客户端，接收客户端套接字
        Socket socket = ss.accept();

        System.out.println("服务器连接成功");

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        while (true) {

            /*服务读取客户端的消息*/
            //准备一个数组
            System.out.println("服务器接收到客户端的消息为：");
            byte[] b=new byte[1024];
            int len=is.read(b);
            String replyWord=new String(b, 0, len);
            System.out.println(replyWord);

            /*服务器响应消息给客户端*/
            //System.out.println("服务器回复客户端的消息为：");
            String word=input.nextLine();
            os.write(word.getBytes());
            os.flush();

            if (word.equals("886")||replyWord.equals("886")) {
                break;
            }

        }

        is.close();
        os.close();
    }
}
