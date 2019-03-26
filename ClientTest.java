package com.qf.javaday1.demo2;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;
import javafx.concurrent.Worker;
import org.omg.CORBA.IRObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: YangRuiGuang
 * @Date: 2019/3/25 20:33
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        Scanner input =new Scanner(System.in);
        Socket socket1=new Socket("10.36.147.188",6666);

        //获得网络输入输出流
        OutputStream os =socket1.getOutputStream();
        InputStream  is = socket1.getInputStream();

        while (true){
            /*客户发消息给服务器*/
            String word =input.nextLine();
            os.write(word.getBytes());
            os.flush();

            if(word.equals("886")){
                break;
            }


            /*客户端接收服务端响应的消息*/
            byte[] b =new byte[1024];
            System.out.println("客户端读取服务器的消息为：");
            int len = is.read(b);
            String replyWord = new String(b,0,len);
            System.out.println(replyWord);

            if(replyWord.equals("886")){
                break;
            }

        }

        os.close();
        is.close();
        socket1.close();
    }
}
