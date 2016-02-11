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

public class ChatClient1 extends JFrame{
	private JPanel p= new JPanel();
	private JTextField jtf1 = new JTextField();
	    private JTextArea jta1 = new JTextArea();
	    private DataOutputStream toserver ;
	    private DataInputStream fromserver;
	    private JButton button  = new JButton("发送");
	   // private Socket client =null;
	     public ChatClient1(){
	    p.setLayout(new BorderLayout());  
	    JPanel p2 = new JPanel();
	    p2.setLayout(new BorderLayout());  
	    p2.add(jtf1,BorderLayout.CENTER);
	    p2.add((new JLabel("NND 你一定不要忘了曾经的承诺和坚持")),BorderLayout.SOUTH);
	    p2.add(button,BorderLayout.EAST);
	    p.add(p2,BorderLayout.SOUTH);
	    p.add(jta1,BorderLayout.CENTER);
	    this.setTitle("最简单的聊天室-----antking");
	    this.add(p);
	    this.setSize(500,300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    button.addActionListener(new buttonListener());
	   
	    try {
	   
	Socket client = new Socket("localhost",54321);
	toserver = new DataOutputStream(client.getOutputStream());
	fromserver = new DataInputStream(client.getInputStream());
	while(true){
	String msg =fromserver.readUTF();
	if(msg!=null)
	jta1.append(msg+"\n");
	}
	} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	     }
	     private class buttonListener implements ActionListener{


	@Override
	public void actionPerformed(ActionEvent e) {
	String str = jtf1.getText().toString();
	try {
	// toserver = new DataOutputStream(client.getOutputStream());
	// fromserver = new DataInputStream(client.getInputStream());
	//
	toserver.writeUTF(str);
	toserver.flush();
	} catch (UnknownHostException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	}
	     
	     }
	public static void main(String[] args) {
	new ChatClient1();


	}

}
