package com.chengjian.exercise.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.chengjian.exercise.dao.BookInforDao;
import com.chengjian.exercise.dao.StudentsInforDao;

public class MainFrm extends JFrame implements ActionListener {
	private String accou;
	private JPanel topPaenl, centerPanel, southPanel,toolBtnPanel;
	private JToolBar toolBar;
	public JButton btnDelete, btnUpdate, btnAdd, btnQuery, btnStu, btnBook,btnExit,btn1,btnSerch;
	private JLabel lblY, lblClass, lblName, lblTerm, lblimage,lbltishi;
	private JComboBox<String> comY, comName, comClass, comTerm;
	private JTextField txtSerch;
	private JMenuBar menuBar;
	private JMenu menuSys, menPrint, menStuMana, menScoreMana, menHelp, menY;
	public JMenuItem menUpdatepass, menExit, menPrintScore, menPrintstu;
	public JMenuItem men1, men2, men3, men4, men5, men6, men7, men8, men9,
			mena, menb, menc;
	private JPanel studentPanel, scorePanel;
	private JScrollPane studentsScrPanel, scoreScrPanel;
	private JTable studensTable, scoreTable;
	private JMenuItem itemUpdate, itemDel;
	private JPopupMenu jPopupMenu;

	public MainFrm(String account){
		
		super();
		this.accou=account;
		this.setSize(800, 700);
		this.setTitle("图书管理系统v1.0");
		this.setLocationRelativeTo(this);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 主窗体的默认布局设置为边界布局
		this.getContentPane().setLayout(new BorderLayout());

		// 组件优化：使用UIManager类进行通用组件统一设置
		Font font = new Font("宋体", Font.PLAIN, 12);
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);

		// 实例化容器对象
		this.topPaenl = new JPanel();
		this.getContentPane().add(this.topPaenl, BorderLayout.NORTH);
		this.topPaenl.setLayout(new BorderLayout());

		this.centerPanel = new JPanel();
		// this.centerPanel.setBackground(Color.green);
		this.centerPanel.setLayout(new BorderLayout());
		// this.centerPanel.setBackground(new ImageIcon("images/"));
		this.getContentPane().add(this.centerPanel, BorderLayout.CENTER);

		this.lblimage = new JLabel(new ImageIcon("images/tushu.jpg"));
		this.centerPanel.add(this.lblimage, BorderLayout.NORTH);
		// this.southPanel=new JPanel();
		// this.getContentPane().add(this.southPanel,BorderLayout.SOUTH);
		// this.southPanel.setLayout(new BorderLayout());
	//	this.aaa=frmlogin.getAccount();
		this.initMenuBar();
		this.initToolBar();
		this.initPopMenu();
		// this.initStudentsTable();

	}

	// 初始化弹出菜单
	public void initPopMenu() {
		this.jPopupMenu = new JPopupMenu();

		this.itemUpdate = new JMenuItem("更新信息");
		this.itemUpdate.addActionListener(this);
		this.itemDel = new JMenuItem("删除信息");
		this.itemDel.addActionListener(this);

		this.jPopupMenu.add(this.itemUpdate);
		this.jPopupMenu.addSeparator();
		this.jPopupMenu.add(this.itemDel);
	}

	// 自定义方法完成对表格的创建及定位
	public void initStudentsTable(){
		this.centerPanel.removeAll();
		// 创建字符串来作为表格标题
		String[] cloumnName = new String[] {  "ID", "姓名", "性别", "借书数量", "班级","电话","借书编号" };
		// 创建表格模型
		DefaultTableModel dm = new DefaultTableModel(cloumnName, 0);
		// 创建表格对象
		this.studensTable = new JTable(dm);
		StudentsInforDao studentsInforDao=new StudentsInforDao();
		studentsInforDao.selectAll(dm);
		// 设置表格行高
		this.studensTable.setRowHeight(25);
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.studensTable.setDefaultRenderer(Object.class,defaultTableCellRenderer);
		// 设置标题栏的高度
		JTableHeader header = this.studensTable.getTableHeader();
		header.setPreferredSize(new Dimension(header.getHeight(), 30));
		// 锁定表格
		this.studensTable.setEnabled(false);
		// 实例化滚动面板
		this.studentsScrPanel = new JScrollPane();
		this.studentsScrPanel.getViewport().add(this.studensTable);
		// 将滚动面板放入studentsPanel中
//		this.studentPanel = new JPanel();
//		this.studentPanel.setLayout(new BorderLayout());
		//this.studentPanel.add(this.studentsScrPanel);
		this.btnAdd = new JButton(new ImageIcon("images/add.png"));// 添加
		this.btnAdd.setToolTipText("添加");
		this.btnQuery = new JButton(new ImageIcon("images/select.png"));// 查询
		this.btnQuery.setToolTipText("查询");
		this.btnUpdate = new JButton(new ImageIcon("images/update.png"));// 修改
		this.btnUpdate.setToolTipText("修改");
		this.btnDelete = new JButton(new ImageIcon("images/delete.png"));// 删除
		this.btnDelete.setToolTipText("删除");
		
		this.toolBtnPanel=new JPanel();
		this.toolBtnPanel.setLayout(new FlowLayout(10));
		//this.toolBtnPanel.add(this.lbltishi);
		this.toolBtnPanel.add(this.btnAdd);
		this.toolBtnPanel.add(this.btnQuery);
		this.toolBtnPanel.add(this.btnUpdate);
		this.toolBtnPanel.add(this.btnDelete);
		
	//	this.toolBtnPanel.add(this.txtSerch);
		//this.toolBtnPanel.add(this.btnSerch);
		
		//this.toolBtnPanel.setBackground(Color.black);
		this.centerPanel.add(this.toolBtnPanel,BorderLayout.NORTH);
		
		this.centerPanel.add(this.studentsScrPanel, BorderLayout.CENTER);
		// 将centerPanel中的内容进行重构
		this.centerPanel.revalidate();

	}

	public void initBookTable() {
		// 创建字符串来作为表格标题
		String[] cloumnName = new String[] { "ID", "书名", "作者", "出版社", "图书类别","库存数量" };
		// 创建表格模型
		DefaultTableModel dm = new DefaultTableModel(cloumnName, 0);
		// 创建表格对象
		this.scoreTable = new JTable(dm) {
			// 个性化表格设置Alt+shift+s,v
			public boolean isCellEditable(int row, int column) {
				return false;// 不允许对表格单元格进行操作
			}
		};
		
		// 设置表格行高
		this.scoreTable.setRowHeight(25);
		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.scoreTable.setDefaultRenderer(Object.class,defaultTableCellRenderer);
		// 添加对表格的动作处理
		this.scoreTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// 获取当前行的数据
					String nam = scoreTable.getModel().getValueAt(scoreTable.getSelectedRow(), 1).toString();
					JOptionPane.showMessageDialog(MainFrm.this, "你点击了:" + nam,"消息", JOptionPane.INFORMATION_MESSAGE);
				}
				// 右键点击处理
				if (e.getModifiers() == Event.META_MASK) {
					// 判断是否当前表格中有选中的行
					if (scoreTable.getSelectedColumnCount() != -1) {
						jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
		});

		// 调用Dao代码实现dam 封装
		BookInforDao book = new BookInforDao();
		book.selectAll(dm);
		this.centerPanel.removeAll();
		// 设置标题栏的高度
		JTableHeader header = this.scoreTable.getTableHeader();
		header.setPreferredSize(new Dimension(header.getHeight(), 30));
		// 锁定表格
		// this.scoreTable.setEnabled(false);
		// 实例化滚动面板
		this.scoreScrPanel = new JScrollPane();
		this.scoreScrPanel.getViewport().add(this.scoreTable);
		// 将滚动面板放入scorePanel中
//		this.scorePanel = new JPanel();
//		this.scorePanel.setLayout(new BorderLayout());
		//this.scorePanel.add(this.scoreScrPanel,BorderLayout.NORTH);
		//this.lbltishi=new JLabel("可对图书表做以下操作：");
		this.btnAdd = new JButton(new ImageIcon("images/add.png"));// 添加
		this.btnAdd.setToolTipText("添加");
		this.btnQuery = new JButton(new ImageIcon("images/select.png"));// 查询
		this.btnQuery.setToolTipText("查询");
		this.btnUpdate = new JButton(new ImageIcon("images/update.png"));// 修改
		this.btnUpdate.setToolTipText("修改");
		this.btnDelete = new JButton(new ImageIcon("images/delete.png"));// 删除
		this.btnDelete.setToolTipText("删除");
//		this.txtSerch=new JTextField();
//		this.btnSerch=new JButton("搜索");
		
		
		this.toolBtnPanel=new JPanel();
		this.toolBtnPanel.setLayout(new FlowLayout(10));
		//this.toolBtnPanel.add(this.lbltishi);
		this.toolBtnPanel.add(this.btnAdd);
		this.toolBtnPanel.add(this.btnQuery);
		this.toolBtnPanel.add(this.btnUpdate);
		this.toolBtnPanel.add(this.btnDelete);
		
	//	this.toolBtnPanel.add(this.txtSerch);
		//this.toolBtnPanel.add(this.btnSerch);
		
		//this.toolBtnPanel.setBackground(Color.black);
		this.centerPanel.add(this.toolBtnPanel,BorderLayout.NORTH);

		//this.centerPanel.setBackground(Color.black);
		this.centerPanel.add(this.scoreScrPanel, BorderLayout.CENTER);
		// 将centerPanel中的内容进行重构
		this.centerPanel.revalidate();
	}

	/*
	 * public void initBookTableView(){
	 * 
	 * 
	 * //创建字符串来作为表格标题 String[] cloumnName=new
	 * String[]{"ID","书名","作者","出版社","图书类别","数量"}; //创建表格模型 DefaultTableModel
	 * dm=new DefaultTableModel(cloumnName,1); //创建表格对象 this.scoreTable=new
	 * JTable(dm); //设置表格行高 this.scoreTable.setRowHeight(25);
	 * 
	 * //调用Dao代码实现dam 封装 // BookInforDao book=new BookInforDao(); //
	 * book.selectOther(dm);
	 * 
	 * //设置标题栏的高度 JTableHeader header=this.scoreTable.getTableHeader();
	 * header.setPreferredSize(new Dimension(header.getHeight(),30)); //锁定表格
	 * this.scoreTable.setEnabled(false); //实例化滚动面板 this.scoreScrPanel=new
	 * JScrollPane(); this.scoreScrPanel.getViewport().add(this.scoreTable);
	 * //将滚动面板放入scorePanel中 this.scorePanel=new JPanel();
	 * this.scorePanel.setLayout(new BorderLayout());
	 * this.scorePanel.add(this.scoreScrPanel); this.southPanel.removeAll();
	 * this.southPanel.add(this.scorePanel,BorderLayout.NORTH);
	 * //将centerPanel中的内容进行重构 this.southPanel.revalidate(); }
	 */

	// 自定义方法完成对工具栏的创建及定位

	// 设置图标按钮显示
//	public void toolView() {
//		
//		this.btnAdd.setVisible(true);
//		this.btnUpdate.setVisible(true);
//		this.btnDelete.setVisible(true);
//		this.btnQuery.setVisible(true);
//	}

	// 显示book表时，按钮的事件监听

	// 自定义方法完成对菜单栏的创建及定位
	public void initMenuBar() {
		// 实例化菜单对象,设置热键
		this.menuBar = new JMenuBar();
		this.menuSys = new JMenu("系统(S)");
		this.menuSys.setMnemonic('S');
		this.menStuMana = new JMenu("学生用户管理(E)");
		this.menStuMana.setMnemonic('E');
		this.menScoreMana = new JMenu("图书管理(C)");
		this.menScoreMana.setMnemonic('C');
		this.menY = new JMenu("关于");
		// this.menY.setMnemonic('Y');
		this.menY.addActionListener(this);
		this.menHelp = new JMenu("帮助(H)");
		this.menHelp.setMnemonic('H');

		this.menPrint = new JMenu("打印");
		this.menUpdatepass = new JMenuItem("修改密码");
		this.menUpdatepass.addActionListener(this);
		this.menUpdatepass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));

		this.menPrintScore = new JMenuItem("打印用户信息");
		this.menPrintScore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));

		this.menPrintstu = new JMenuItem("打印图书信息");
		this.menPrintstu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));

		this.menExit = new JMenuItem("退出系统");
		this.menExit.addActionListener(this);
		this.menExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));

		this.men1 = new JMenuItem("全部用户信息");
		this.men1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		this.men1.addActionListener(this);
		this.men2 = new JMenuItem("增加用户");
		this.men2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		this.men2.addActionListener(this);
		this.men3 = new JMenuItem("删除用户");
		this.men3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
		this.men3.addActionListener(this);
		this.men4 = new JMenuItem("修改用户");
		this.men4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		this.men4.addActionListener(this);
		this.men5 = new JMenuItem("查询用户");
		this.men5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		this.men5.addActionListener(this);

		this.men6 = new JMenuItem("全部图书信息");
		this.men6.addActionListener(this);
		this.men7 = new JMenuItem("增加图书");
		this.men7.addActionListener(this);
		this.men8 = new JMenuItem("删除图书");
		this.men8.addActionListener(this);
		this.men9 = new JMenuItem("修改图书");
		this.men9.addActionListener(this);
		this.mena = new JMenuItem("查询图书");
		this.mena.addActionListener(this);
		// 将菜单添加到相应的容器中
		this.menuBar.add(this.menuSys);
		this.menuBar.add(this.menStuMana);
		this.menuBar.add(this.menScoreMana);
		this.menuBar.add(this.menY);
		this.menuBar.add(this.menHelp);

		this.menuSys.add(this.menUpdatepass);
		this.menuSys.addSeparator();
		this.menuSys.add(this.menPrint);
		this.menuSys.addSeparator();
		this.menuSys.add(this.menExit);
		this.menPrint.add(this.menPrintstu);
		this.menPrint.addSeparator();
		this.menPrint.add(this.menPrintScore);

		this.menStuMana.add(this.men1);
		this.menStuMana.addSeparator();
		this.menStuMana.add(this.men2);
		this.menStuMana.add(this.men3);
		this.menStuMana.add(this.men4);
		this.menStuMana.add(this.men5);

		this.menScoreMana.add(this.men6);
		this.menScoreMana.addSeparator();
		this.menScoreMana.add(this.men7);
		this.menScoreMana.add(this.men8);
		this.menScoreMana.add(this.men9);
		this.menScoreMana.add(this.mena);
		this.topPaenl.add(this.menuBar, BorderLayout.NORTH);
	}

	public void initToolBar() {
		// 实例化JToolBar对象
		this.toolBar = new JToolBar();
		// this.toolBar.setLayout(new BorderLayout());
		// 实例化工具栏中的各种组件
		
		this.btnStu = new JButton(new ImageIcon("images/student.gif"));// 显示学生表
		this.btnStu.setToolTipText("显示学生表");
		this.btnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//toolView();
				initStudentsTable();
				toolStuView();
			}
		});
		this.btnBook = new JButton(new ImageIcon("images/book.gif"));// 显示图书表
		this.btnBook.setToolTipText("显示图书表");
		this.btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	toolView();
				initBookTable();
				toolBookVieww();
			}
		});
		this.btnExit = new JButton(new ImageIcon("images/exit.gif"));// 退出
		this.btnExit.setToolTipText("退出");
		this.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取要删除的行,没有选择是-1
				int n = JOptionPane.showConfirmDialog(null, "确定退出系统吗?","确认是否退出框", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

//		this.btnAdd.setVisible(false);
//		this.btnUpdate.setVisible(false);
//		this.btnDelete.setVisible(false);
//		this.btnQuery.setVisible(false);

//		this.lblY = new JLabel("所在院系：");
//		this.lblClass = new JLabel("班级：");
		this.lblName = new JLabel("请输入图书编号：");
		this.txtSerch=new JTextField(45);
		this.btnSerch=new JButton("借出");
		
		//this.lblTerm = new JLabel("学期：");

		//String[] itemY = new String[] { "计算机学院", "艺术学院", "土木学院", "外国语学院" };
		//.comY = new JComboBox(itemY);
//		String[] itemName = new String[] { "顾壮", "黄运驰", "鲍官恒", "王如南" };
//		this.comName = new JComboBox(itemName);
//		String[] itemTerm = new String[] { "第一学期", "第二学期", "第三学期", "第四学期" };
//		this.comTerm = new JComboBox(itemTerm);
//		String[] itemClass = new String[] { "软件一班", "软件二班", "软件三班", "软件四班" };
//		this.comClass = new JComboBox(itemClass);

		// 将组件添加到ToolBar中
//		this.toolBar.add(this.btnAdd);
//		this.toolBar.add(this.btnUpdate);
//		this.toolBar.add(this.btnDelete);
//		this.toolBar.add(this.btnQuery);
		this.toolBar.add(this.btnStu);
		this.toolBar.add(this.btnBook);
		this.toolBar.add(this.btnExit);

	//	this.toolBar.add(this.comY);
	//	this.toolBar.add(this.lblClass);
	//	this.toolBar.add(this.comClass);
		this.toolBar.add(this.lblName);
		this.toolBar.add(this.txtSerch);
		this.toolBar.add(this.btnSerch);
		this.btnSerch.addActionListener(this);
	//	this.toolBar.add(this.comTerm);
		// 将工具栏放入topPanel中
		this.topPaenl.add(this.toolBar, BorderLayout.SOUTH);
		
		this.toolBar.revalidate();
	}

	// 为图书表工具栏添加监听
	public void toolBookVieww() {
		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookAdd frm4 = new FrmBookAdd();
				frm4.setVisible(true);
			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookUpate frm4 = new FrmBookUpate();
				frm4.setVisible(true);
			}
		});

		this.btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookQuery frm4 = new FrmBookQuery();
				frm4.setVisible(true);
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBookDelete frm4 = new FrmBookDelete();
				frm4.setVisible(true);
			}
		});
	}

	// 为学生表添加按钮监听
	public void toolStuView() {
		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAdd frm4 = new FrmAdd();
				frm4.setVisible(true);
			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmUpdate frm4 = new FrmUpdate();
				frm4.setVisible(true);
			}
		});

		this.btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuery frm4 = new FrmQuery();
				frm4.setVisible(true);
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDelete frm4 = new FrmDelete();
				frm4.setVisible(true);
			}
		});
	}
//	public void setAaa(FrmLogin frmlogin){
//		this.aaa=frmlogin.getAccount();
//	}
	
//	public String getAaa(){
//	
//	return this.aaa;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String scmd = e.getActionCommand();
		
//		if (scmd.equals("借出")) {
//
//			FrmBookUpate frm5 = new FrmBookUpate();
//			frm5.setVisible(true);
//			String a=this.txtSerch.getText().trim();
//			
//
//		}
		
		if (scmd.equals("修改密码")) {
			FrmUpPassword frr = new FrmUpPassword(this.accou);
			frr.setVisible(true);

			// JOptionPane.showMessageDialog(this,
			// "正在开发中....","消息",JOptionPane.INFORMATION_MESSAGE);
		}
		if (scmd.equals("全部用户信息")) {
			//this.toolView();
			initStudentsTable();
			this.toolStuView();
		}
		if (scmd.equals("增加用户")) {
			FrmAdd frm1 = new FrmAdd();
			frm1.setVisible(true);

		}
		if (scmd.equals("删除用户")) {
			FrmDelete frm1 = new FrmDelete();
			frm1.setVisible(true);

		}
		if (scmd.equals("查询用户")) {
			FrmQuery frm2 = new FrmQuery();
			frm2.setVisible(true);

		}
		if (scmd.equals("修改用户")) {
			FrmUpdate frm3 = new FrmUpdate();
			frm3.setVisible(true);

		}
		if (scmd.equals("增加图书")) {
			FrmBookAdd frm4 = new FrmBookAdd();
			frm4.setVisible(true);

		}
		if (scmd.equals("删除图书")) {
			FrmBookDelete frm1 = new FrmBookDelete();
			frm1.setVisible(true);

		}
		if (scmd.equals("修改图书")) {

			FrmBookUpate frm5 = new FrmBookUpate();
			frm5.setVisible(true);

		}
		if (scmd.equals("查询图书")) {
			FrmBookQuery frm6 = new FrmBookQuery();
			frm6.setVisible(true);

		}
		if (scmd.equals("全部图书信息")){
			//this.toolView();
			initBookTable();
			this.toolBookVieww();
			// initBookTableView();
		}

		if (scmd.equals("退出系统")) {
			if ((JOptionPane.showConfirmDialog(this, "确定退出系统吗？")) == 0) {
				System.exit(0);
			}
		}
		if (scmd.equals("关于")) {
			FrmAbout frm6 = new FrmAbout();
			frm6.setVisible(true);
		}
		if(e.getSource() instanceof JMenuItem){
			JMenuItem 	clickedItem=(JMenuItem)e.getSource();
			if(clickedItem==this.itemDel){
				int id=Integer.parseInt(this.scoreTable.getModel().getValueAt(this.scoreTable.getSelectedRow(),0).toString());
				int res=JOptionPane.showConfirmDialog(this,"确定删除编号为"+id+"的信息吗？");
				if(res==0){
				BookInforDao bookinforDao=new BookInforDao();
				boolean flag=bookinforDao.delete(id);
				if(flag){
					initBookTable();
					JOptionPane.showMessageDialog(this,"删除成功","消息",JOptionPane.INFORMATION_MESSAGE);
				}else{
					
					JOptionPane.showMessageDialog(this,"删除失败","错误",JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
			
			
		}
	}

//	public static void main(String[] args) {
//
//		MainFrm frm = new MainFrm("sdf");
//		frm.setVisible(true);
//	}

}
