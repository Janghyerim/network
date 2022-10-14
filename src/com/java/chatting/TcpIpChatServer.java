package com.java.chatting;

import java.io.IOException;
import java.net.*;

public class TcpIpChatServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		Socket socket = null;
		
		try {
			serversocket = new ServerSocket(7777);
			System.out.println("������ �����");
			socket = serversocket.accept();
			
			Sender sender = new Sender(socket);  //������ ��� ���� �ϰ� ȣ��
			sender.start();
			
			Receiver receiver = new Receiver(socket);  //�޴� ��� ���� �ϰ� ȣ��
			receiver.start();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
