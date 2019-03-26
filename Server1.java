package com.qf.charroom1902.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 聊天室的服务器端
 */
public class Server1 {
	/**
	 * 存储服务器端为每个客户端开启线程对象
	 */
	static ArrayList<ServerThread> stList=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		//创建服务器端套接字对象
		ServerSocket ss=new ServerSocket(9999);
		System.out.println("客户端与服务器正在连接中...");
		while (true) {
			//监听客户端，并接收客户端Socket对象
			Socket socket1=ss.accept();
			System.out.println("来了一个客户端...");
			//来了一个客户端就开启一个线程
			ServerThread t1=new ServerThread(socket1);
			//再将客户端对应的每个服务器端的线程对象存到集合中
			stList.add(t1);
			//启动
			t1.start();
		}

	}

}
