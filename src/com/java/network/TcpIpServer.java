package com.java.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {

		ServerSocket serversocket = null;  //서버소켓은 최초 연결감지만 할 수 있게 담당한다.
		// 필요정보 : Ip / 포트번호 -> ex)아파트 단지 내에 몇동몇호 같은 존재
		try {
			serversocket = new ServerSocket(7777); // 포트번호 지정, 6000번 이상 으로 쓰면 된다.
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			
			try {
				System.out.println("연결요청을 기다립니다.");
				Socket socket = serversocket.accept(); //serversocket.accept(); : 최초 연결 상태 를  socket에 넘긴다.
				System.out.println(socket.getInetAddress() + " 로 부터 연결 요청이 들어옴.");
				
				OutputStream out = socket.getOutputStream();  //서버에서 아웃하면 클라이언트는 인이고, 클라이언트에서 내보내면 서버는 들어온다.
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF(" [Notice] 접속 성공 Message from Server "); //문자를 보낼때 글씨 깨지는걸 보호방지(인코딩)하여 UTF로 작성함.
				System.out.println("데이터를 전송했습니다.");
				dos.close(); //꼭 닫아줘야 한다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
