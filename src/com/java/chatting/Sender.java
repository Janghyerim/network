package com.java.chatting;

import java.io.*;
import java.net.*;
import java.util.*;
                     //스레드를 상속하면 런메소드를 오버라이딩 해줘야 한다.
public class Sender extends Thread{ //문자를 보내는 기능을 구현 
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
		
		while(out != null) {  //out스트림이 살아있을때까지 돌아간다. 값이 null일때까지
			try {
				out.writeUTF(name + sc.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
