package com.greatlearning.jdbccore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnectivityConcept {
	public static void main(String[] args) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LPG", "root", "root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from cust_details");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t " + resultSet.getString(2) + "\t " + resultSet.getString(3)
						+ "\t " + resultSet.getString(4) + "\t " + resultSet.getLong(5) + "\t "
						+ resultSet.getBigDecimal(6) + "\t " + resultSet.getInt(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
