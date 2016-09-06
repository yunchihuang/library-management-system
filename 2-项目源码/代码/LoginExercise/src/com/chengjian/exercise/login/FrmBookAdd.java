package com.chengjian.exercise.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.chengjian.exercise.dao.BookInforDao;
import com.chengjian.exercise.dao.UserInforDao;

public class FrmBookAdd extends JFrame implements ActionListener {
	private JPanel topPanel,buttonPanel;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JTextField txt1,txt2,txt3,txt4,txt5,txt6;
	private JButton btnEnsure,btnCannel;
	public FrmBookAdd(){
		
		super();
		this.setSize(new Dimension(500,500));
		this.setTitle("增加学生用户窗体");
		this.setLocationRelativeTo(this);
//		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		//组件优化：使用UIManager进行组件优化
		Font font = new Font("宋体", Font.PLAIN, 12);
		UIManager.put("Label.font", font);//统一标签的字体
		UIManager.put("Button.font", font);//统一按钮的字体
		
		//实例化topPanel容器对象（设置面板）
		this.topPanel=new JPanel();
		this.topPanel.setLayout(null);
		this.topPanel.setBounds(new Rectangle(20,20,440,420));
		this.topPanel.setBorder(BorderFactory.createTitledBorder(null, "添加图书", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION));
		//this.topPanel.setBackground(Color.white);
		this.getContentPane().add(topPanel);
	
		this.lbl7 = new JLabel("请输入需要添加的图书:");
		this.lbl7.setBounds(new Rectangle(120,30, 300,30));
		this.lbl7.setFont(new Font("宋体", Font.BOLD, 16));
		this.topPanel.add(this.lbl7);
		
		this.lbl1 = new JLabel("ID:" );
		this.lbl1.setBounds(new Rectangle(20, 70, 40,40));
		this.topPanel.add(this.lbl1);
		
		this.lbl2 = new JLabel("书名:" );
		this.lbl2.setBounds(new Rectangle(250, 70, 60,40));
		this.topPanel.add(this.lbl2);
		
		this.lbl3 = new JLabel("作者:");
		this.lbl3.setBounds(new Rectangle(20, 150, 60,40));
		this.topPanel.add(this.lbl3);
		
		this.lbl4 = new JLabel("出版社:");
		this.lbl4.setBounds(new Rectangle(250, 150, 60,40));
		this.topPanel.add(this.lbl4);
		
		this.lbl5 = new JLabel("图书类别:");
		this.lbl5.setBounds(new Rectangle(20, 230, 60,40));
		this.topPanel.add(this.lbl5);
		
		this.lbl6 = new JLabel("图书数量:");
		this.lbl6.setBounds(new Rectangle(240, 230, 70,40));
		this.topPanel.add(this.lbl6);
		

		
		this.txt1= new JTextField();
		this.txt1.setBounds(new Rectangle(80, 80, 120,30));
		this.topPanel.add(txt1);
		
		this.txt2= new JTextField();
		this.txt2.setBounds(new Rectangle(290, 80, 120,30));
		this.topPanel.add(txt2);
		
		this.txt3 = new JTextField();
		this.txt3.setBounds(new Rectangle(80, 160, 120,30));
		this.topPanel.add(txt3);
		
		this.txt4 = new JTextField();
		this.txt4.setBounds(new Rectangle(290, 160, 120,30));
		this.topPanel.add(txt4);
		
		this.txt5 = new JTextField();
		this.txt5.setBounds(new Rectangle(80, 240, 120,30));
		this.topPanel.add(txt5);
		
		this.txt6 = new JTextField();
		this.txt6.setBounds(new Rectangle(290, 240, 120,30));
		this.topPanel.add(txt6);
		
		this.btnEnsure =new JButton("确定");
		this.btnEnsure.setBounds(new Rectangle(140, 350, 100, 30));
		this.btnEnsure.addActionListener(this);
		this.topPanel.add(this.btnEnsure);

		this.btnCannel =new JButton("取消");
		this.btnCannel.setBounds(new Rectangle(290, 350, 100, 30));
		this.btnCannel.addActionListener(this);
		this.topPanel.add(this.btnCannel);	
	}	
	
	
	public void actionPerformed(ActionEvent e) {
		String scmd=e.getActionCommand();
		if(scmd.equals("取消")){
			this.setVisible(false);
		}
		if(scmd.equals("确定")){
			String a=txt2.getText().trim();
			String b=txt3.getText().trim();
			String c=txt4.getText().trim();
			String d=txt5.getText().trim();
			String f=txt6.getText().trim();
			if((a==null||a.length()==0)||(b==null||b.length()==0)||(c==null||c.length()==0)||(d==null||d.length()==0)||(f==null||f.length()==0)){
				JOptionPane.showMessageDialog(this, "请补全图书信息", "消息", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
			//视图层调用Dao层实现业务操作
		    BookInforDao bookInforDao=new BookInforDao();
			String strSQL="insert into  bookinfor value(null,?,?,?,?,?)";
			Object[] params=new Object[]{a,b,c,d,f};	
			int res=bookInforDao.insert(strSQL, params);
			String message=res>0?"恭喜！添加成功！" : "对不起添加失败...";
				JOptionPane.showMessageDialog(this, message, "消息", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
//				MainFrm frm=new MainFrm();
//				frm.setVisible(true);
			}
		}

	}
	public static void main(String[] args) {
		FrmBookAdd frm=new FrmBookAdd();
		frm.setVisible(true);
	}

}
