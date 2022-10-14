package com.java.chatting;

import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;
import java.net.*;

public class TcpIpMultiChatServer {

	HashMap clients; // k : 사용자아이디 , v : 각 값이 가진 Stream정보

	public TcpIpMultiChatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients); // 동시다발적으로 접근하면 막히니 락을 걸려면 synchronizedMap 써야하고
										      // 맵에 관한 것이므로 Collections.synchronizedMap 쓰고 대상은 clients가 된다.
	}

	public void start() { //서버 실행
		ServerSocket serversocket = null;
		Socket socket = null;
		
		try {
			serversocket = new ServerSocket(7777);// 서버소켓 생성
			System.out.println("서버 시작됨"); 
			
			while(true) {
				socket = serversocket.accept(); //클라이언트로부터 연결요청 대기
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void sendToAll(String msg) { // 모든클라이언트의 메세지 전달 , 닉네임을 받아서 실제 데이터를 처리 하게끔 하는 것.
		 
	}
	
	public static void main(String[] args) {
		 new TcpIpMultiChatServer().start(); //자기자신 생성
	}

}
