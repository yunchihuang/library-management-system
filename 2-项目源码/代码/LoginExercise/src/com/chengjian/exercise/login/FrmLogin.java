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

/**
 * 作者：顾壮 
 * 日期：2015-01-05 13:16 
 * 名称：FrmLogin 
 * 功能：系统登录界面 最后修改时间：2015-01-05 13:16
 * */
public class FrmLogin extends JFrame implements ActionListener {
	// 声明两个Panel面板对象
	private JPanel loginPanel, buttonPanel;
	private String account;
	// 声明GUI组件
	private JLabel lblAccount, lblPassword;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	private JButton btnRegister, btnLogin;

	public FrmLogin() {
		super();
		// 设置窗体大小
		this.setSize(new Dimension(350, 200));
		// 设置窗体标题
		this.setTitle("图书管理系统v1.0");
		// 设置窗体居中显示
		this.setLocationRelativeTo(this);
		// 禁用窗体最大化按钮
		this.setResizable(false);
		// 设置窗体关闭窗口进程的操作
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 组件优化：使用UIManager类进行通用组件统一设置
		Font font = new Font("黑体", Font.PLAIN, 12);
		// 统一标签字体
		UIManager.put("JLabel.font", font);
		// 统一按钮字体
		UIManager.put("JButton.font", font);
		// 设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		// 实例化loginPanel容器对象（设置面板）
		this.loginPanel = new JPanel();
		this.loginPanel.setLayout(null);
		this.loginPanel.setBounds(new Rectangle(0, 0, 350, 110));
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(loginPanel);
		// 实例化buttonPanel容器对象（设置面板）
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBounds(new Rectangle(0, 110, 350, 90));
		this.getContentPane().add(buttonPanel);
		// 为loginPanel容器添加组件
		this.lblAccount = new JLabel("登录帐号：");
		this.lblAccount.setBounds(new Rectangle(60, 20, 69, 30));
		this.loginPanel.add(this.lblAccount);

		this.lblPassword = new JLabel("登录密码：");
		this.lblPassword.setBounds(new Rectangle(60, 60, 69, 30));
		this.loginPanel.add(this.lblPassword);

		this.txtAccount = new JTextField();
		this.txtAccount.setBounds(new Rectangle(135, 20, 150, 30));
		this.loginPanel.add(this.txtAccount);

		this.txtPassword = new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(135, 60, 150, 30));
		this.loginPanel.add(this.txtPassword);
		// 为buttonPanel容器添加组件
		this.btnRegister = new JButton("立即注册");
		this.btnRegister.setBounds(new Rectangle(55, 18, 100, 30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);

		this.btnLogin = new JButton("马上登录");
		this.btnLogin.setBounds(new Rectangle(195, 18, 100, 30));
		this.btnLogin.addActionListener(this);
		this.buttonPanel.add(this.btnLogin);

	}
	public void setAccount(String aa){
		this.account=aa;
	}
	
	public String getAccount(){
	
	return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="立即注册"){
			//弹出对话框MessageDialog
			FrmRegister frm1=new FrmRegister();
			frm1.setVisible(true);
			this.setVisible(false);
			//JOptionPane.showMessageDialog(this, "您点击了注册按钮", "消息", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand()=="马上登录"){
			String account=this.txtAccount.getText().trim();
			String password=this.txtPassword.getText().trim();
			if((account==null||account.length()==0)||(password==null||password.length()==0)){
				JOptionPane.showMessageDialog(this, "账号或密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
			}
		
			else{
				
				 UserInforDao userInforDao=new UserInforDao();
			
				boolean flag= userInforDao.isLogin(account,password);
				if(flag){
					JOptionPane.showConfirmDialog(this, "欢迎登陆,"+account,"提示",JOptionPane.ERROR_MESSAGE);
					String getpower=userInforDao.Power(account);
					if(getpower.equals("管理员")){
					MainFrm frmMain = new MainFrm(account);
					frmMain.setVisible(true);
					this.setVisible(false);
					}
					else{
						MainFrmUser frmMain = new MainFrmUser(account);
						frmMain.setVisible(true);
						this.setVisible(false);
					}
				}
				//视图层调用Dao层实现业务操作
				else{
				JOptionPane.showMessageDialog(this,"账号密码错误！","錯誤！",JOptionPane.ERROR_MESSAGE);}
				this.txtAccount.setText("");
				this.txtPassword.setText("");
				this.txtAccount.requestFocus();
			}
		}
	}
	public static void main(String[] args) {

		FrmLogin frm = new FrmLogin();
		frm.setVisible(true);
	}
}
