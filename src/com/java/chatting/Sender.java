package com.java.chatting;

import java.io.*;
import java.net.*;
import java.util.*;
                     //�����带 ����ϸ� ���޼ҵ带 �������̵� ����� �Ѵ�.
public class Sender extends Thread{ //���ڸ� ������ ����� ���� 
	Socket socket;
	DataOutputStream out;
	String name;
	
	
	public Sender(Socket socket) {
		super();
		this.socket = socket;
		
		try {
			out = new DataOutputStream(socket.getOutputStream());  
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while(out != null) {  //out��Ʈ���� ������������� ���ư���. ���� null�϶�����
			try {
				out.writeUTF(name + sc.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
