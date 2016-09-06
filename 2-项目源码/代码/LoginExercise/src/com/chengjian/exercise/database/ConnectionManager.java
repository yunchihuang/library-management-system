package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	// 方法1：获取一个有效的数据库链接对象
	public Connection openConnection() {
		try {
			// 加载链接驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 设置数据库链接参数
			String account = "root";
			String password = "1";
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			// 使用DriverManager获取一个有效链接
			Connection connection = DriverManager.getConnection(url, account,
					password);
			System.out.println("消息：成功获取一个有效的数据库链接对象……");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 方法2：关闭一个有效的数据库链接对象
	public void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("消息：正常关闭一个有效的数据库链接对象……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
