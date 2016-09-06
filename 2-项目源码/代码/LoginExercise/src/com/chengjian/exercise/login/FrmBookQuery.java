package com.chengjian.exercise.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.chengjian.exercise.dao.BookInforDao;

public class FrmBookQuery extends JFrame implements ActionListener {

	private JPanel Panel,buttonPanel,Panel2,scorePanel;
	private JScrollPane scoreScrPanel;
	private JLabel lblQuery;
	private JTextField txtQuery;
	private JButton btnEnsure,btnCannel;
	private JTable viewTable;
	private JComboBox combox;
	public FrmBookQuery(){
		
		super();
		this.setSize(new Dimension(600,550));
		this.setTitle("查询图书窗体");
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//设置窗体的默认面板容器的布局模式为null
		this.getContentPane().setLayout(null);
		
		//实例化Panel容器对象（设置面板）
		this.Panel=new JPanel();
		this.Panel.setLayout(null);
		this.Panel.setBounds(new Rectangle(0,0,600,140));
		this.Panel.setBackground(Color.white);
		this.getContentPane().add(Panel);
		//实例化Panel容器对象（设置面板）
		this.Panel2=new JPanel();
		this.Panel2.setLayout(new BorderLayout());
		this.Panel2.setBorder(BorderFactory.createTitledBorder(null,"查询结果",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		this.Panel2.setBounds(new Rectangle(10,160,580,360));
		//this.Panel2.setBackground(Color.black);
		this.getContentPane().add(Panel2);
		//实例化buttonPanel容器对象（设置面板）
//		this.buttonPanel=new JPanel();
//		this.buttonPanel.setLayout(null);
//		this.buttonPanel.setBounds(new Rectangle(0,140,600,80));
		//this.buttonPanel.setBackground(Color.blue);
		//this.getContentPane().add(buttonPanel);
		
		this.lblQuery=new JLabel("请选择查询方式：");
		this.lblQuery.setBounds(new Rectangle(60, 60, 150,30));
		this.Panel.add(this.lblQuery);
		
		String []str=new String[]{"id","作者","书名"};
		this.combox=new JComboBox(str);
		this.combox.setBounds(new Rectangle(180,60,60,30));
		this.Panel.add(this.combox);
		
		this.txtQuery=new JTextField();
		this.txtQuery.setBounds(new Rectangle(280,60,150,30));
		this.Panel.add(this.txtQuery);
		
		this.btnEnsure=new JButton("查询");
		this.btnEnsure.setBounds(new Rectangle(455,60,80,30));
		this.btnEnsure.addActionListener(this);
		this.Panel.add(this.btnEnsure);
		
		
//		this.btnCannel=new JButton("取消");
//		this.btnCannel.setBounds(new Rectangle(170,10,70,30));
//		this.btnCannel.addActionListener(this);
//		this.buttonPanel.add(this.btnCannel);
		
	}
	public String getTxtQuery(){
	
	return txtQuery.getText();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String scmd=e.getActionCommand();
		if(scmd.equals("取消")){
			this.setVisible(false);
		}
		if(scmd.equals("查询")){
			String f=txtQuery.getText().trim();
			//获取下拉列表中的值
			String select=(String) this.combox.getSelectedItem();
			if(select.equals("id")){select="id";}
			if(select.equals("作者")){select="bzuozhe";}
			if(select.equals("书名")){select="bname";}
			//视图层调用Dao层实现业务操作
		    BookInforDao bookInforDao=new BookInforDao();
			String strSQL="select * from bookinfor where "+select+"=?";
			Object[] params=new Object[]{f};
			//创建字符串来作为表格标题
			String[] cloumnName=new String[]{"ID","书名","作者","出版社","图书类别","数量"};
			//创建表格模型
			DefaultTableModel dm=new DefaultTableModel(cloumnName,0);
		
			//创建表格对象
			this.viewTable=new JTable(dm);
			
			//设置表格行高
			this.viewTable.setRowHeight(25);
			
			//设置标题栏的高度
			JTableHeader header=this.viewTable.getTableHeader();
			header.setPreferredSize(new Dimension(header.getHeight(),30));
			//锁定表格
			this.viewTable.setEnabled(false);
			
			bookInforDao.selectOther(dm,strSQL, params);
			
			//实例化滚动面板
			this.scoreScrPanel=new JScrollPane();
			this.scoreScrPanel.getViewport().add(this.viewTable);
			//将滚动面板放入scorePanel中
			this.scorePanel=new JPanel();
			this.scorePanel.setLayout(new BorderLayout());
			this.scorePanel.add(this.scoreScrPanel);
			this.Panel2.removeAll();
			this.Panel2.add(this.scorePanel,BorderLayout.CENTER);
			//将centerPanel中的内容进行重构
			this.Panel2.revalidate();	
			
//			String message=res>0?"恭喜！查询成功！" : "对不起查询失败...";
				//JOptionPane.showMessageDialog(this, message, "消息", JOptionPane.INFORMATION_MESSAGE);
				//this.setVisible(false);
//				MainFrm frm=new MainFrm();
//				frm.setVisible(true);
		}
	}
public static void main(String[] args) {
	FrmBookQuery frm=new FrmBookQuery();
	frm.setVisible(true);
}
}