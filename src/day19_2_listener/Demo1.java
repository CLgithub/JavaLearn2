package day19_2_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
监听器
	问题：什么是监听器，监听器有什么作用
		概念：
			1.事件		ActionEvent
			2.事件源		JButton
			3.监听器		ActionListener
			4.注册监听	addActionListener
		监听器就是可以监听某个事物在执行一个特定操作时，我们可以让其触发一个操作
		可以在满足特定条件的情况下执行一段操作
	
		
*/
public class Demo1 extends JFrame {
	private JButton button = new JButton("按钮");	//事件源
	//事件：button被按下就是一个事件，ActionEvent 对ActionEvent事件的监听器就是ActionListener
	
	public Demo1() {
		button.addActionListener(new ButListener());	//注册监听
		this.getContentPane().add(button);
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Demo1();
	}
}
//监听器
class ButListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("aaaa");
	}
	
}