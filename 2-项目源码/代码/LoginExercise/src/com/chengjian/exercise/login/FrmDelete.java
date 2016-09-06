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
import javax.swing.JTextField;

public class FrmDelete extends JFrame implements ActionListener {
	

	private JPanel Panel,buttonPanel;
	private JLabel lblQuery;
	//private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	public FrmDelete(){
		
		super();
		this.setSize(new Dimension(320,220));
		this.setTitle("删除学生窗体");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		
		//实例化Panel容器对象（设置面板）
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,320,140));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		//实例化buttonPanel容器对象（设置面板）
		this.buttonPanel=new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0,140,320,80));
		//this.buttonPanel.setBackground(Color.blue);
		this.getContentPane().add(buttonPanel);
		
		this.lblQuery=new JLabel("你确定要删除"+"         "+"这位用户吗？");
		this.lblQuery.setBounds(new Rectangle(30, 60, 320,30));
		this.Panel.add(this.lblQuery);
		
		
		this.btnEnsure=new JButton("确定");
		this.btnEnsure.setBounds(new Rectangle(70,10,70,30));
		//this.btnEnsure.addActionListener(this);
		this.buttonPanel.add(this.btnEnsure);
		
		this.btnCannel=new JButton("取消");
		this.btnCannel.setBounds(new Rectangle(170,10,70,30));
		this.btnCannel.addActionListener(this);
		this.buttonPanel.add(this.btnCannel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String scmd=e.getActionCommand();
		if(scmd.equals("取消")){
			this.setVisible(false);
		}

	}
public static void main(String[] args) {
	FrmDelete frm=new FrmDelete();
	frm.setVisible(true);
}
}
