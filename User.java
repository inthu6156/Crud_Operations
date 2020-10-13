package com.hcl.user;

import java.sql.*;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseURL = "jdbc:ucanaccess://C:/Users/shaik-inthiyaz/Documents/gtb.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			System.out.println("Connected To MS Access database.");

			String sql1 = "update Contacts set FullName='Shaik Mamola' where ID=2";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			int row = preparedStatement1.executeUpdate();

			String sql = "INSERT INTO Contacts (FullName, Email, Phone) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "mounika");
			preparedStatement.setString(2, "kririti@gmail.com");
			preparedStatement.setString(3, "9895967976");

			int row1 = preparedStatement.executeUpdate();

			if (row1 > 0) {
				System.out.println("A row has been inserted successfully.");
			}

			sql = "SELECT * FROM Contacts";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("ID");
				String fullname = result.getString("FullName");
				String email = result.getString("Email");
				String phone = result.getString("Phone");

				System.out.println(id + ", " + fullname + ", " + email + ", " + phone);
			}

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM Contacts WHERE id =1");
			preparedStatement.setInt(1, 3);

			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
