package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.chengjian.exercise.dao.UserInforDao;

public class FrmUpPassword extends JFrame implements ActionListener {
	private String ccc;
	private JPanel loginPanel,buttonPanel;
	//声明GUI组件
	private JLabel lblAccount,lblOldPassword,lblPassword,lblEnPassword;
	private JTextField txtAccount;
	private JPasswordField txtOldPassword,txtPassword,txtEnPassword;
	private JButton btnRegister,btnLogin;
	public FrmUpPassword(String ccc) {
		
		super();
		this.ccc=ccc;
		//设置窗体大小
		this.setSize(new Dimension(350,280));
		//设置窗体标题
		this.setTitle("修改密码窗体");
		//设置窗体居中显示
		this.setLocationRelativeTo(this);
		//禁用窗体最大化按钮
		this.setResizable(false);
		//设置窗体关闭窗口进程的操作
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//组件优化：使用UIManager类进行通用组件统一设置
		Font font=new Font("黑体",Font.PLAIN,12);
		//统一标签字体
		UIManager.put("JLabel.font", font);
		//统一按钮字体
		UIManager.put("JButton.font",font);
		//设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		//实例化loginPanel容器对象（设置面板）
		this.loginPanel=new JPanel();
		this.loginPanel.setLayout(null);
		this.loginPanel.setBounds(new Rectangle(0,0,350,180));
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(loginPanel);
		//实例化buttonPanel容器对象（设置面板）
		this.buttonPanel=new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0,180,350,70));
		this.getContentPane().add(buttonPanel);
		//为loginPanel容器添加组件
//		this.lblAccount=new JLabel("用户名：");
//		this.lblAccount.setBounds(new Rectangle(60, 20, 69,30));
//		this.loginPanel.add(this.lblAccount);
		
		this.lblOldPassword=new JLabel("旧密码：");
		this.lblOldPassword.setBounds(new Rectangle(60, 30,69,30));
		this.loginPanel.add(this.lblOldPassword);
		
		this.lblPassword=new JLabel("新密码：");
		this.lblPassword.setBounds(new Rectangle(60, 80,69,30));
		this.loginPanel.add(this.lblPassword);
		
		this.lblEnPassword=new JLabel("确认密码：");
		this.lblEnPassword.setBounds(new Rectangle(60, 130,69,30));
		this.loginPanel.add(this.lblEnPassword);
		
//		this.txtAccount=new JTextField();
//		this.txtAccount.setBounds(new Rectangle(135,20,150,30));
//		this.loginPanel.add(this.txtAccount);
		
		this.txtOldPassword=new JPasswordField();
		this.txtOldPassword.setBounds(new Rectangle(135,30,150,30));
		this.loginPanel.add(this.txtOldPassword);
		
		this.txtPassword=new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(135,80,150,30));
		this.loginPanel.add(this.txtPassword);
		
		this.txtEnPassword=new JPasswordField();
		this.txtEnPassword.setBounds(new Rectangle(135,130,150,30));
		this.loginPanel.add(this.txtEnPassword);
		
		//为buttonPanel容器添加组件
		this.btnRegister=new JButton("确定");
		this.btnRegister.setBounds(new Rectangle(55,18,100,30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);
		
		this.btnLogin=new JButton("取消");
		this.btnLogin.setBounds(new Rectangle(195,18,100,30));
		this.btnLogin.addActionListener(this);
		this.buttonPanel.add(this.btnLogin);
	
		
	}
	public  String getCcc(){
		return this.ccc;
	}
	
	public void actionPerformed(ActionEvent e) {
		String com=e.getActionCommand();
		if(com.equals("取消")){
			
			this.setVisible(false);
		}
		if(com.equals("确定")){
		
			String acc=this.getCcc();
			System.out.print(ccc);
			String pass=txtPassword.getText().trim();
			//视图层调用Dao层实现业务操作
		    UserInforDao userInforDao=new UserInforDao();
			String strSQL="update userinfor set pass=? where account=?";
			Object[] params=new Object[]{pass,acc};	
			int res=userInforDao.insert(strSQL, params);
			String message=res>0?"恭喜！修改成功！" : "对不起修改失败，请联系管理员...";
			JOptionPane.showMessageDialog(this, message, "消息", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
//			FrmLogin frm1=new FrmLogin();
//			frm1.setVisible(true);
		}
	}
//public static void main(String[] args) {
//	
//	FrmUpPassword frm=new FrmUpPassword();
//	frm.setVisible(true);
//}
	
}
