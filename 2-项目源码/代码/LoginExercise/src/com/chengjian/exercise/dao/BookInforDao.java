package com.chengjian.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;
import com.chengjian.exercise.login.FrmBookQuery; 

public class BookInforDao {
	public void selectAll(final DefaultTableModel dm){
			// 步骤1：获取一个有效的数据库链接
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();

			// 步骤2：设置SQL语句和数据参数
			String strSQL = "select * from bookinfor order by id";
			Object[] params = new Object[] {};

			// 步骤3：发送SQL语句
			SQLManager sqlManager = new SQLManager();
			ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

			try {
				while (rs.next()) {
					Vector rowData=new Vector();
					rowData.add(rs.getInt(1));
					rowData.add(rs.getString(2));
					rowData.add(rs.getString(3));
					rowData.add(rs.getString(4));
					rowData.add(rs.getString(5));
					rowData.add(rs.getInt(6));
					dm.addRow(rowData);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 步骤4：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);

		}
	
	//查询
	public void selectOther(final DefaultTableModel dm,final String strSQL,final Object...params){
		// 步骤1：获取一个有效的数据库链接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		
		FrmBookQuery frm=new FrmBookQuery();
		String a=frm.getTxtQuery();
		// 步骤3：发送SQL语句
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			while (rs.next()) {
				Vector rowData=new Vector();
				rowData.add(rs.getInt(1));
				rowData.add(rs.getString(2));
				rowData.add(rs.getString(3));
				rowData.add(rs.getString(4));
				rowData.add(rs.getString(5));
				rowData.add(rs.getInt(6));
				dm.addRow(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 步骤4：关闭一个有效的数据库链接
		connectionManager.closeConnection(connection);

	}
		//完成对Bookinfor数据表的添加操作
		public int insert(final String strSQL,final Object...params){
			// 步骤1：获取一个有效的数据库链接
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();

			// 步骤2：开启一个事务处理（只有写操作的时候使用事务）
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);

			// 步骤3：发送SQL语句
			SQLManager sqlManager = new SQLManager();
			int res = sqlManager.executeWrite(connection, strSQL, params);

			// 步骤4：根据数据库执行结果提交或回滚事务
			if (res > 0) {
				transactionManager.commitTransaction(connection);
			} else {
				transactionManager.rollbackTransaction(connection);
			}
		
			// 步骤5：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);
			return res;
		
	}
		//修改1操作
		public String[] update(final String strSQL,final Object...params){
			String []uper=new String[5]; 
			// 步骤1：获取一个有效的数据库链接
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();
			
			FrmBookQuery frm=new FrmBookQuery();
			String a=frm.getTxtQuery();
			// 步骤3：发送SQL语句
			SQLManager sqlManager = new SQLManager();
			ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

			try {
				while (rs.next()) {
					//Vector rowData=new Vector();
					uper[0]=rs.getString(2);
					uper[1]=rs.getString(3);
					uper[2]=rs.getString(4);
					uper[3]=rs.getString(5);
					uper[4]=rs.getString(6);
					//dm.addRow(rowData);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 步骤4：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);
			return uper;
		}
		//完成对Bookinfor数据表的update2操作
		public int xiugai(final String strSQL,final Object...params){
			// 步骤1：获取一个有效的数据库链接
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();

			// 步骤2：开启一个事务处理（只有写操作的时候使用事务）
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);

			// 步骤3：发送SQL语句
			SQLManager sqlManager = new SQLManager();
			int res = sqlManager.executeWrite(connection, strSQL, params);

			// 步骤4：根据数据库执行结果提交或回滚事务
			if (res > 0) {
				transactionManager.commitTransaction(connection);
			} else {
				transactionManager.rollbackTransaction(connection);
			}
		
			// 步骤5：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);
			return res;
		
	}
		
		//删除操作
		public int delete(final String strSQL,final Object...params){
			// 步骤1：获取一个有效的数据库链接
			ConnectionManager connectionManager = new ConnectionManager();
			Connection connection = connectionManager.openConnection();

			// 步骤2：开启一个事务处理（只有写操作的时候使用事务）
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);

			// 步骤3：发送SQL语句
			SQLManager sqlManager = new SQLManager();
			int res = sqlManager.executeWrite(connection, strSQL, params);

			// 步骤4：根据数据库执行结果提交或回滚事务
			if (res > 0) {
				transactionManager.commitTransaction(connection);
			} else {
				transactionManager.rollbackTransaction(connection);
			}
				
			// 步骤5：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);
			return res;
				
			}

	public boolean delete(final int bid) {
		// 步骤1：获取一个有效的数据库链接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// 步骤2：开启一个事务处理（只有写操作的时候使用事务）
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.beginTransaction(connection);

		// 步骤3：发送SQL语句
		SQLManager sqlManager = new SQLManager();
		String strSQL="delete from bookinfor where id=?";
		Object[] params=new Object[]{bid};
		int res = sqlManager.executeWrite(connection, strSQL, params);

		// 步骤4：根据数据库执行结果提交或回滚事务
		if (res > 0) {
			transactionManager.commitTransaction(connection);
			connectionManager.closeConnection(connection);
			return true;
		} else {
			transactionManager.rollbackTransaction(connection);
			connectionManager.closeConnection(connection);
			return false;
		}
	}
}
