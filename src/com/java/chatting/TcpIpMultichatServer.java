package com.java.chatting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

//public class TcpIpMultiChatServer {
//
//	//HashMap clients; // k : 사용자아이디 , v : 각 값이 가진 Stream정보
//
//	public TcpIpMultiChatServer() {
////		clients = new HashMap();
////		Collections.synchronizedMap(clients); // 동시다발적으로 접근하면 막히니 락을 걸려면 synchronizedMap 써야하고
//										      // 맵에 관한 것이므로 Collections.synchronizedMap 쓰고 대상은 clients가 된다.
//	}
//
//	public void start() { //서버 실행
//		ServerSocket serversocket = null;
//		Socket socket = null;
//		
//		try {
//			serversocket = new ServerSocket(7777);// 서버소켓 생성
//			System.out.println("서버 시작됨"); 
//			
//			while(true) {
//				socket = serversocket.accept(); //클라이언트로부터 연결요청 대기
//				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
//				ServerReceiver_old thread = new ServerReceiver_old(socket);
//				thread.start();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		 new TcpIpMultiChatServer().start(); //자기자신 생성
//	}
//
	public class TcpIpMultichatServer {
		HashMap clients;

		TcpIpMultichatServer() {
			clients = new HashMap();
			Collections.synchronizedMap(clients);
		}

		public void start() {
			ServerSocket serverSocket = null;
			Socket socket = null;

			try {
				serverSocket = new ServerSocket(7777);
				System.out.println("서버가 시작되었습니다.");

				while (true) {
					socket = serverSocket.accept();
					System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
					ServerReceiver thread = new ServerReceiver(socket);
					thread.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // start()

		void sendToAll(String msg) {
			Iterator it = clients.keySet().iterator();

			while (it.hasNext()) {
				try {
					DataOutputStream out = (DataOutputStream) clients.get(it.next());
					out.writeUTF(msg);
				} catch (IOException e) {
				}
			} // while
		} // sendToAll

		public static void main(String args[]) {
			new TcpIpMultichatServer().start();
		}

		class ServerReceiver extends Thread {
			Socket socket;
			DataInputStream in;
			DataOutputStream out;

			ServerReceiver(Socket socket) {
				this.socket = socket;
				try {
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
				} catch (IOException e) {
				}
			}

			public void run() {
				String name = "";
				try {
					name = in.readUTF();
					sendToAll("#" + name + "님이 들어오셨습니다.");

					clients.put(name, out);
					System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

					while (in != null) {
						sendToAll(in.readUTF());
					}
				} catch (IOException e) {
					// ignore
				} finally {
					sendToAll("#" + name + "님이 나가셨습니다.");
					clients.remove(name);
					System.out
							.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
					System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
				} // try
			} // run
		} // ReceiverThread
	} // class


