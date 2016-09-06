package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chengjian.exercise.database.ConnectionManager;
import com.chengjian.exercise.database.SQLManager;
import com.chengjian.exercise.database.TransactionManager;

public class Test2 {

	public static void main(String[] args) {
		// 查询数据
		// 步骤1：获取一个有效的数据库链接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();

		// 步骤2：设置SQL语句和数据参数
		String strSQL = "select * from userinfor order by uid ";
		Object[] params = new Object[] {};

		// 步骤3：发送SQL语句
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.executeRead(connection, strSQL, params);

		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 步骤4：关闭一个有效的数据库链接
		connectionManager.closeConnection(connection);

	}

}
