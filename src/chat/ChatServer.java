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

import chat.ChatServer1.Task;

public class ChatServer extends JFrame{
	private static JTextArea jta = new JTextArea();
	private ServerSocket server;
	private static List<Socket> list = new ArrayList<Socket>();
	private ExecutorService exec;
	
	public ChatServer(){
		setLayout(new BorderLayout());
		add(new JScrollPane(jta),BorderLayout.CENTER);
		setTitle("聊天室服务器");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try {
			server = new ServerSocket(54321);
			exec = Executors.newCachedThreadPool();
			jta.append("服务器已经启动");
			Socket client = null;
			while(true){
				 client =server.accept();
				 list.add(client);
				 exec.execute(new Task(client));
				 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Task implements Runnable{

		private Socket client;
		private DataInputStream fromClient;
		private DataOutputStream toClient;
		String msg;
		
		public Task(Socket client) throws IOException{
			this.client = client;
			fromClient = new DataInputStream(client.getInputStream());
		}
		@Override
		public void run() {
			try {
				while((msg=fromClient.readUTF())!=null){
					msg = "["+client.getPort()+"]说："+msg;
					jta.append(msg + "\n");
					sendMessage();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		public void sendMessage() throws IOException{
			for(Socket client:list){
				toClient = new DataOutputStream(client.getOutputStream());
				toClient.writeUTF(msg);
				
			}
		}
		
	}
	
	public static void main(String[] args){
		new ChatServer();
	}
	
	
}
