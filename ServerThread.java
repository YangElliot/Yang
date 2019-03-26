package com.qf.charroom1902.demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * 服务器端的线程
 * @author sx
 * @version 1.0 2019年3月26日
 */
public class ServerThread extends Thread{
	//声明与当前线程对应 客户端的读，写的流
	BufferedReader br;
	BufferedWriter bw;

	/**
	 * 将当前线程对应客户端的Socket作为参数传过来，获得当前线程对应的客户端网络读，写的流
	 * 构造方法
	 * @param socket1
	 */
	public ServerThread(Socket socket1) {
		try {
			br=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			//接收客户端的姓名
			String uname=br.readLine();
			//将客户端的姓名存储在当前对应 线程中
			this.setName(uname);
			//创建欢迎消息
			String word="欢迎"+uname+"进入聊天室";
			//将消息转发给所有客户
			for (ServerThread c : Server1.stList) {
				c.bw.write(word);
				//每写一次换行
				c.bw.newLine();
				c.bw.flush();
			}
			
			
			while (true) {
				//接收客户端的聊天内容
				String content=br.readLine();
				if (content.startsWith("@")) {//私聊
					String[] ss=content.substring(1).split("#");
					String privateWord=this.getName()+"悄悄对"+ss[0]+"说："+ss[1];
					//找到私聊的人，发消息
					for (ServerThread c : Server1.stList) {
						if (c.getName().equals(ss[0])&&!c.getName().equals(this.getName())) {
							c.bw.write(privateWord);
							c.bw.newLine();
							c.bw.flush();
							break;
						}
					}
				}else {//群聊
					content=this.getName()+"说:"+content;
					//将内容转发给其他所有客户端,但是要除去自己
					for (ServerThread c : Server1.stList) {
						if (!c.getName().equals(this.getName())) {
							c.bw.write(content);
							//每写一次换行
							c.bw.newLine();
							c.bw.flush();
						}
					}
				}
			}
		} catch (SocketException e1) {//有客户端退出
			try {
				//创建退出的语句
				String returnWord=this.getName()+"退出群聊系统";
				//将当前所对应的客户端的服务器线程从集合中移除
				Server1.stList.remove(this);
				//将当前客户退出的消息群发给其他的客户
				for (ServerThread c : Server1.stList) {
					c.bw.write(returnWord);
					//每写一次换行
					c.bw.newLine();
					c.bw.flush();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
