package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class main {

	static DatagramSocket dsocket ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 9000;
		try {
			 dsocket = new DatagramSocket(port);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			
		}
		System.out.println("conect");
		byte[] buffer;
		String msg;
		for(int i=0;i<100;i++){
			
			buffer= new byte[2048];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			// Wait to receive a datagram
			try {
				dsocket.receive(packet);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				}

			// Convert the contents to a string, and display them
			 msg = new String(buffer, 0, packet.getLength());
			System.out.println(msg);
		}
	}

}
