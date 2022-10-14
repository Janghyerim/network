package com.java.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {

		ServerSocket serversocket = null;  //���������� ���� ���ᰨ���� �� �� �ְ� ����Ѵ�.
		// �ʿ����� : Ip / ��Ʈ��ȣ -> ex)����Ʈ ���� ���� ���ȣ ���� ����
		try {
			serversocket = new ServerSocket(7777); // ��Ʈ��ȣ ����, 6000�� �̻� ���� ���� �ȴ�.
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			
			try {
				System.out.println("�����û�� ��ٸ��ϴ�.");
				Socket socket = serversocket.accept(); //serversocket.accept(); : ���� ���� ���� ��  socket�� �ѱ��.
				System.out.println(socket.getInetAddress() + " �� ���� ���� ��û�� ����.");
				
				OutputStream out = socket.getOutputStream();  //�������� �ƿ��ϸ� Ŭ���̾�Ʈ�� ���̰�, Ŭ���̾�Ʈ���� �������� ������ ���´�.
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF(" [Notice] ���� ���� Message from Server "); //���ڸ� ������ �۾� �����°� ��ȣ����(���ڵ�)�Ͽ� UTF�� �ۼ���.
				System.out.println("�����͸� �����߽��ϴ�.");
				dos.close(); //�� �ݾ���� �Ѵ�.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
