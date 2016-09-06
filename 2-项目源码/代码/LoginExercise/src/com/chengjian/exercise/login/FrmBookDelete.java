package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.chengjian.exercise.dao.BookInforDao;

public class FrmBookDelete extends JFrame implements ActionListener {

	private JPanel Panel,buttonPanel;
	private JLabel lblQuery;
	private JTextField txtj;
	//private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	public FrmBookDelete(){
		
		super();
		this.setSize(new Dimension(320,220));
		this.setTitle("删除图书窗体");
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
		
		this.lblQuery=new JLabel("请输入要删除的图书的ID:");
		this.lblQuery.setBounds(new Rectangle(10, 60,160,30));
		this.Panel.add(this.lblQuery);
		
		this.txtj=new JTextField();
		this.txtj.setBounds(new Rectangle(170,60,140,30));
		this.Panel.add(this.txtj);
		
		
		this.btnEnsure=new JButton("确定");
		this.btnEnsure.setBounds(new Rectangle(70,10,70,30));
		this.btnEnsure.addActionListener(this);
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
		if(scmd.equals("确定")){
			// TODO Auto-generated method stub
			//获取要删除的行,没有选择是-1
			int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			String d=txtj.getText().trim();
			//视图层调用Dao层实现业务操作
		    BookInforDao bookInforDao=new BookInforDao();
			String strSQL="delete from  bookinfor where id=?";
			Object[] params=new Object[]{d};	
			int res=bookInforDao.insert(strSQL, params);
			String message=res>0?"恭喜！删除成功！" : "对不起删除失败...";
				JOptionPane.showMessageDialog(this, message, "消息", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
				} else if (n == JOptionPane.NO_OPTION) {
				this.setVisible(false);
		}
//			if(e.getActionCommand()!=null){
//			MainFrm ff=new MainFrm();
//			ff.setVisible(true);
//			}
			} 
		
	}
public static void main(String[] args) {
	FrmBookDelete frm=new FrmBookDelete();
	frm.setVisible(true);
}
}
