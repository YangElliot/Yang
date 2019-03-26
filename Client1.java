package com.qf.charroom1902.demo1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	public static void main(String[] args) throws Exception {
		//创建客户端socket对象
		Socket socket1=new Socket("127.0.0.1", 9999);
		//创建客户端的读与写的线程
		ReadThread r=new ReadThread(socket1);
		WriteThread w=new WriteThread(socket1);
		
		//启动写与读的线程
		w.start();
		r.start();
	}

}
