package com.qf.charroom1902.demo1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端写的线程
 * @author sx
 * @version 1.0 2019年3月26日
 */
public class WriteThread extends Thread{
	//声明网络写入流
	BufferedWriter w;

	/**
	 * 用客户端的socket对象作为参数构造方法
	 * @param socket1
	 */
	public WriteThread(Socket socket1) {
		try {
			w=new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		Scanner input=new Scanner(System.in);
		try {
			System.out.println("请输入姓名：");
			String uname=input.nextLine();
			//将姓名发送服务端
			w.write(uname);
			//换行
			w.newLine();
			w.flush();
			
			//循环向服务端发消息
			while (true) {
				String word=input.nextLine();
				w.write(word);
				w.newLine();
				w.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
