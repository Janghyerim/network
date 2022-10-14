package com.java.network;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class TcpIpClient {

	public static void main(String[] args) {  //수기로 예외처리 해줘야 한다 try-catch
		System.out.println("서버에 연결 합니다..");
		try {
			Socket socket = new Socket("192.168.0.62",7777);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("서버로 부터 받은 메세지" + dis.readUTF()); //readUTF() : 값을 받아오다 , writeUTF() : 값을 보내다
			System.out.println("연결 종료");
			
			dis.close();
			socket.close(); //완전히 서버 종료

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
