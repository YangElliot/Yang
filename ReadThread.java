package com.qf.charroom1902.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端读的线程
 * @author sx
 * @version 1.0 2019年3月26日
 */
public class ReadThread extends Thread{
	//声明网络读取流
	BufferedReader r;

	/**
	 * 将客户端的Socket对象作为参数传递构造方法
	 * @param socket1
	 */
	public ReadThread(Socket socket1) {
		try {
			r=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				String word = r.readLine();
				System.out.println(word);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
