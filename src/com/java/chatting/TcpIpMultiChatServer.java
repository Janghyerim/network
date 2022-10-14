package com.java.chatting;

import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;
import java.net.*;

public class TcpIpMultiChatServer {

	HashMap clients; // k : ����ھ��̵� , v : �� ���� ���� Stream����

	public TcpIpMultiChatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients); // ���ôٹ������� �����ϸ� ������ ���� �ɷ��� synchronizedMap ����ϰ�
										      // �ʿ� ���� ���̹Ƿ� Collections.synchronizedMap ���� ����� clients�� �ȴ�.
	}

	public void start() { //���� ����
		ServerSocket serversocket = null;
		Socket socket = null;
		
		try {
			serversocket = new ServerSocket(7777);// �������� ����
			System.out.println("���� ���۵�"); 
			
			while(true) {
				socket = serversocket.accept(); //Ŭ���̾�Ʈ�κ��� �����û ���
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� �����Ͽ����ϴ�.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void sendToAll(String msg) { // ���Ŭ���̾�Ʈ�� �޼��� ���� , �г����� �޾Ƽ� ���� �����͸� ó�� �ϰԲ� �ϴ� ��.
		 
	}
	
	public static void main(String[] args) {
		 new TcpIpMultiChatServer().start(); //�ڱ��ڽ� ����
	}

}
