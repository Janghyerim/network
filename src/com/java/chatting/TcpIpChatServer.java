package com.java.chatting;

import java.io.IOException;
import java.net.*;

public class TcpIpChatServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		Socket socket = null;
		
		try {
			serversocket = new ServerSocket(7777);
			System.out.println("서버가 실행됨");
			socket = serversocket.accept();
			
			Sender sender = new Sender(socket);  //보내는 기능 생성 하고 호출
			sender.start();
			
			Receiver receiver = new Receiver(socket);  //받는 기능 생성 하고 호출
			receiver.start();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
