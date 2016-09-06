package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.chengjian.exercise.dao.UserInforDao;

public class FrmRegister extends JFrame implements ActionListener {
	//声明容器
	private JPanel titlePanel,loginPanel,personalPanel,buttonPanel;
	private JLabel lblTitle,lblInformation,lblAccount,lblPassword,
	lblEnsurePassw,lblHint1,lblHint2,lblHint3,lblHint4,lblHint5,
	lblName,lblEmail,lbltype;
	private JComboBox comType;
	private JTextField txtAccount,txtName,txtEmail;
	private JPasswordField txtPassword,txtEnsurePasseord;
	private JButton btnRegister,btnReturn;
	public FrmRegister(){
		this.setSize(new Dimension(600,750));
		this.setTitle("图书管理系v1.0");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Font font=new Font("微软雅黑",Font.PLAIN,12);
		UIManager.put("JLabel.font", font);
		
		
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.white);
		//设置titlePanel标题容器
		this.titlePanel=new JPanel();
		this.titlePanel.setBounds(new Rectangle(30,30,540,110));
		this.titlePanel.setLayout(null);
		this.titlePanel.setBackground(Color.white);
		this.getContentPane().add(this.titlePanel);
		//为titlePanel容器添加组件
		this.lblTitle=new JLabel("新用户注册");
		this.lblTitle.setFont(new Font("黑体",Font.BOLD,18));
		this.lblTitle.setBounds(new Rectangle(0, 10, 100,40));
		this.titlePanel.add(this.lblTitle);
				
		this.lblInformation=new JLabel("用户注册需要填写新账户的账户信息以及个人信息，请按照提示要求正确填写。");
		this.lblInformation.setBounds(new Rectangle(0, 50,480,20));
		this.titlePanel.add(this.lblInformation);
		
		//设置loginPanel登录信息容器
		this.loginPanel=new JPanel();
		this.loginPanel.setBounds(new Rectangle(30,140,540,180));
		this.loginPanel.setBorder(BorderFactory.createTitledBorder(null,"账户信息",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.loginPanel.setLayout(null);
		this.loginPanel.setBackground(Color.white);
		this.getContentPane().add(this.loginPanel);
		
		//为loginPanel容器添加组件
		this.lblAccount=new JLabel("登录帐号：");
		this.lblAccount.setBounds(new Rectangle(20, 30, 80,30));
		this.loginPanel.add(this.lblAccount);
		
		this.txtAccount=new JTextField();
		this.txtAccount.setBounds(new Rectangle(100,30,150,30));
		this.loginPanel.add(this.txtAccount);
		
		this.lblHint1=new JLabel("仅有字母和下划线组成");
		this.lblHint1.setBounds(new Rectangle(270, 30, 180,30));
		this.loginPanel.add(this.lblHint1);
		
		this.lblPassword=new JLabel("登录密码：");
		this.lblPassword.setBounds(new Rectangle(20, 80, 80,30));
		this.loginPanel.add(this.lblPassword);
		
		this.txtPassword=new JPasswordField();
		this.txtPassword.setBounds(new Rectangle(100,80,150,30));
		this.loginPanel.add(this.txtPassword);
		
		this.lblHint2=new JLabel("密码不少于六位，仅有字母和下划线组成");
		this.lblHint2.setBounds(new Rectangle(270, 80, 280,30));
		this.loginPanel.add(this.lblHint2);
		
		this.lblEnsurePassw=new JLabel("密码确认：");
		this.lblEnsurePassw.setBounds(new Rectangle(20, 130, 80,30));
		this.loginPanel.add(this.lblEnsurePassw);
		
		this.txtEnsurePasseord=new JPasswordField();
		this.txtEnsurePasseord.setBounds(new Rectangle(100,130,150,30));
		this.loginPanel.add(this.txtEnsurePasseord);
		
		this.lblHint3=new JLabel("两次密码保持一致");
		this.lblHint3.setBounds(new Rectangle(270, 130, 280,30));
		this.loginPanel.add(this.lblHint3);
		
		
		
		//设置personalPanel个人信息容器
		this.personalPanel=new JPanel();
		this.personalPanel.setBounds(new Rectangle(30,320,540,220));
		this.personalPanel.setBorder(BorderFactory.createTitledBorder(null,"个人信息",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.personalPanel.setLayout(null);
		this.personalPanel.setBackground(Color.white);
		this.getContentPane().add(this.personalPanel);
		//为personalPanel容器添加组件
		this.lblName=new JLabel("真实姓名：");
		this.lblName.setBounds(new Rectangle(20, 50, 80,30));
		this.personalPanel.add(this.lblName);
				
		this.txtName=new JTextField();
		this.txtName.setBounds(new Rectangle(100,50,150,30));
		this.personalPanel.add(this.txtName);
				
		this.lblHint4=new JLabel("填写真实的个人姓名");
		this.lblHint4.setBounds(new Rectangle(270, 50, 180,30));
		this.personalPanel.add(this.lblHint4);
		
		this.lblEmail=new JLabel("电子邮箱：");
		this.lblEmail.setBounds(new Rectangle(20, 100, 80,30));
		this.personalPanel.add(this.lblEmail);
				
		this.txtEmail=new JTextField();
		this.txtEmail.setBounds(new Rectangle(100,100,150,30));
		this.personalPanel.add(this.txtEmail);
				
		this.lblHint5=new JLabel("请按照邮箱规则进行填写，包含‘@’字符");
		this.lblHint5.setBounds(new Rectangle(270, 100, 280,30));
		this.personalPanel.add(this.lblHint5);
		
		this.lbltype=new JLabel("请选择注册类型：");
		this.lbltype.setBounds(new Rectangle(20, 150, 120,30));
		this.personalPanel.add(this.lbltype);
		
		String []tt=new String[]{"普通用户"};
		this.comType=new JComboBox(tt);
		this.comType.setBounds(new Rectangle(130, 150, 80,30));
		this.personalPanel.add(this.comType);
		
		//设置buttonPanel按钮容器
		this.buttonPanel=new JPanel();
		this.buttonPanel.setBounds(new Rectangle(30,560,540,90));
		this.buttonPanel.setLayout(null);
		this.buttonPanel.setBackground(Color.white);
		this.getContentPane().add(this.buttonPanel);
		//为buttonPanel容器添加组件
		this.btnRegister=new JButton("立即注册");
		this.btnRegister.setBounds(new Rectangle(320,30,100,30));
		this.btnRegister.addActionListener(this);
		this.buttonPanel.add(this.btnRegister);
				
		this.btnReturn=new JButton("返回");
		this.btnReturn.setBounds(new Rectangle(430,30,100,30));
		this.btnReturn.addActionListener(this);
		this.buttonPanel.add(this.btnReturn);
	}
	
//	private AbstractButton titlePanel() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String com=e.getActionCommand();
		if(com=="返回"){
			this.setVisible(false);
			FrmLogin frm1=new FrmLogin();
			frm1.setVisible(true);
			//弹出对话框MessageDialog
			
			//JOptionPane.showMessageDialog(this, "您点击了注册按钮", "消息", JOptionPane.INFORMATION_MESSAGE);
		}
		String tpe=(String) this.comType.getSelectedItem();
		String account = this.txtAccount.getText().trim();
		String name = this.txtName.getText().trim();
		String mail = this.txtEmail.getText().trim();
		String password = this.txtPassword.getText().trim();
		String enPassword = this.txtEnsurePasseord.getText().trim();
		 String reg = "[\\w]+@[\\w]+.[\\w]+";
		if(com=="立即注册"){
//			txtAccount,txtName,txtEmail;
//			private JPasswordField txtPassword,txtEnsurePasseord;
			
			
			
			if((account == null|| account.length()==0)||(name == null|| name.length()==0)||
					(mail == null|| mail.length()==0)||(password == null|| password.length()==0)||
					(enPassword == null|| enPassword.length()==0)){
				JOptionPane.showMessageDialog(this, "还有信息未填写", "警告", JOptionPane.WARNING_MESSAGE);
			}
			else if(password.length()<6){
				JOptionPane.showMessageDialog(this, "密码不能少于六位数", "警告", JOptionPane.WARNING_MESSAGE);
			}
			else if(!password.equals(enPassword)){
				JOptionPane.showMessageDialog(this, "两次密码不一致", "警告", JOptionPane.WARNING_MESSAGE);
			}
			else if(!mail.matches(reg)){
				JOptionPane.showMessageDialog(this, "输入邮箱格式不合法", "警告", JOptionPane.WARNING_MESSAGE);
			}
			else if(!account.matches("[A-Za-z0-9_]+")){
				JOptionPane.showMessageDialog(this, "输入的用户名不合法", "警告", JOptionPane.WARNING_MESSAGE);
			}else{
			
				//视图层调用Dao层实现业务操作
			    UserInforDao userInforDao=new UserInforDao();
				String strSQL="insert into  userinfor value(null,?,?,?,?,?)";
				Object[] params=new Object[]{account,password,name,mail,tpe};	
				int res=userInforDao.insert(strSQL, params);
				String message=res>0?"恭喜！注册成功！" : "对不起注册失败，请联系管理员...";
					JOptionPane.showMessageDialog(this, "注册成功", "消息", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					FrmLogin frm1=new FrmLogin();
					frm1.setVisible(true);
			}	
		}
	}
	
public static void main(String[] args) {
	FrmRegister rr=new FrmRegister();
	rr.setVisible(true);
}

}
