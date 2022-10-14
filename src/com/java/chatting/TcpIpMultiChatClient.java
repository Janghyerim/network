package com.java.chatting;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpIpMultiChatClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("닉네임 입력 : ");
		String nickName = sc.next();
		
		try {
			Socket socket = new Socket("192.168.0.62",7777);
			System.out.println("서버에 연결됨");
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
