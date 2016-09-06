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

public class StudentsInforDao {
	public void selectAll(final DefaultTableModel dm){
		// 步骤1：获取一个有效的数据库链接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// 步骤2：设置SQL语句和数据参数
		String strSQL = "select * from studentsinfor order by stuid";
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
				rowData.add(rs.getInt(4));
				rowData.add(rs.getString(5));
				rowData.add(rs.getInt(6));
				rowData.add(rs.getInt(7));
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
					rowData.add(rs.getInt(4));
					rowData.add(rs.getString(5));
					rowData.add(rs.getInt(6));
					rowData.add(rs.getInt(7));
					dm.addRow(rowData);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 步骤4：关闭一个有效的数据库链接
			connectionManager.closeConnection(connection);

		}
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
	

}
