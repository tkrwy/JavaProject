package chat;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatServer1 extends JFrame{
	private static JTextArea jta = new JTextArea();
	private ServerSocket server;
	private static List<Socket> list = new ArrayList<Socket>();
	    private ExecutorService exec;
	public ChatServer1(){
	setLayout(new BorderLayout());
	add(new JScrollPane(jta),BorderLayout.CENTER);
	setTitle("�����ҷ�����");
	setSize(500,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	try{
	 server = new ServerSocket(54321);
	 exec = Executors.newCachedThreadPool();
	 
	jta.append("�������Ѿ�����");
	 Socket client = null;
	 while(true){
	 client =server.accept();
	 list.add(client);
	 exec.execute(new Task(client));
	 
	 }
	}catch(Exception e){
	}
	}
	static class Task implements Runnable{
	private Socket client;
	        private DataInputStream fromclient;
	        private DataOutputStream toclient;
	        String msg;
	public Task(Socket client) throws IOException{
	  this.client = client;
	  fromclient = new DataInputStream(client.getInputStream());
	}
	public void run() {
	try{
	while((msg=fromclient.readUTF())!=null){
	msg = "["+client.getPort()+"]˵��"+msg;
	jta.append(msg+"\n");
	sendMessage();
	}
	}catch(Exception e){
	}
	}
	public void sendMessage() throws IOException{
	for(Socket client:list){
	toclient= new DataOutputStream(client.getOutputStream());
	toclient.writeUTF(msg);
	}
	}
	}
	public static void main(String[] args){
	new ChatServer1();
	}

}
