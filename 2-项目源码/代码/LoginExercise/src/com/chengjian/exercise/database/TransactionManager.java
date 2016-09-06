package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

	// 方法1：开启事务
	public void beginTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				System.out.println("消息：启动事务……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 方法2：提交事务
	public void commitTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
				System.out.println("消息：提交事务……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 方法3：回滚事务
	public void rollbackTransaction(final Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
				System.out.println("消息：回滚事务……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
