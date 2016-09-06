package com.chengjian.exercise.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {

	// 方法1：用于执行数据库的写操作（增删改）
	// insert into 表名称 values(null, ？, ？, ....);
	public int executeWrite(final Connection connection, final String strSQL,
			final Object... params) {
		try {
			System.out.println("SQL:> " + strSQL);
			PreparedStatement pstmt = connection.prepareStatement(strSQL);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	// 方法2：用于执行数据库的读操作（查询）
	public ResultSet executeRead(final Connection connection,
			final String strSQL, final Object... params) {
		try {
			System.out.println("SQL:> " + strSQL);
			PreparedStatement pstmt = connection.prepareStatement(strSQL);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
