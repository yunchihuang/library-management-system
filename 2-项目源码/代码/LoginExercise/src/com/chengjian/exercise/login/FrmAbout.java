package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmAbout extends JFrame implements ActionListener {
	private JPanel Panel;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	//private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	public FrmAbout(){
		
		super();
		this.setSize(new Dimension(320,420));
		this.setTitle("关于我们");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		
		//实例化Panel容器对象（设置面板）
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,320,420));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		
		this.lbl1=new JLabel("作者：顾壮");
		this.lbl1.setBounds(new Rectangle(30, 60, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("使用工具：Java语言   Eclipse  MySQL");
		this.lbl1.setBounds(new Rectangle(30, 100, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("系统名称：图书管理系统");
		this.lbl1.setBounds(new Rectangle(30, 140, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("运行环境：Jdk1.7以上");
		this.lbl1.setBounds(new Rectangle(30, 180, 320,30));
		this.Panel.add(this.lbl1);
		
		this.lbl1=new JLabel("开发时间：2016-01-13");
		this.lbl1.setBounds(new Rectangle(30, 220, 320,30));
		this.Panel.add(this.lbl1);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FrmAbout frm=new FrmAbout();
frm.setVisible(true);

	}

}
