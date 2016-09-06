package com.chengjian.exercise.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;

public class UserInforDao {
	public String Power(final String account){
		String getPower=null;
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		
		String strSQL = "select * from userinfor where account=?";
		Object[] params = new Object[]{account};
		
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);
		
		try {
			while(rs.next()){

				if (account.equals(rs.getString(2))){
					getPower = rs.getString(6);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
			connectionManager.closeConnection(connection);
		}
		return getPower ;
	}
	
	//完成对Userinfor数据表的添加操作
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
	
	public int update(final String strSQL,final Object...params){
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
	
	//完成对Userinfor数据表的登录验证操作
	public Boolean isLogin(final String account,final String password){
		
		
		// 步骤1：获取一个有效的数据库链接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// 步骤2：设置SQL语句和数据参数
		String strSQL = "select count(*) from userinfor where account=? and pass=?";
		Object[] params = new Object[] {account,password};

		// 步骤3：发送SQL语句
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			if(rs.next()) {
				int res=rs.getInt(1);
				return res>0?true:false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
		// 步骤4：关闭一个有效的数据库链接
		connectionManager.closeConnection(connection);
		}
			return null;
	}
	
	}
