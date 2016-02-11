package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	private JPanel p = new JPanel();
	private JTextField jtf= new JTextField();
	private JTextArea jta = new JTextArea();
	private JButton button = new JButton("发送");
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	public ChatClient(){
		p.setLayout(new BorderLayout());
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(jtf, BorderLayout.CENTER);
		p2.add(new JLabel("你一定不要忘了曾经的承诺和坚持"), BorderLayout.SOUTH);
		p2.add(button, BorderLayout.EAST);
		
		p.add(p2,BorderLayout.SOUTH);
		p.add(jta, BorderLayout.CENTER);
		
		this.setTitle("最简单的聊天室");
		this.add(p);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		button.addActionListener(new ButtonListener());
		
		Socket client;
		try {
			client = new Socket("localhost", 54321);
			toServer = new DataOutputStream(client.getOutputStream());
			fromServer = new DataInputStream(client.getInputStream());
			while(true){
				String msg = fromServer.readUTF();
				if(msg != null){
					jta.append(msg + "\n");
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = jtf.getText().toString();
			try {
				toServer.writeUTF(str);
				toServer.flush();
				jtf.setText("");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	public static void main(String[] args){
		new ChatClient();
	}
}
