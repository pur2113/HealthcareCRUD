package com.paytm.learnwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.paytm.learnwebapp.model.User;
import com.paytm.learnwebapp.service.UserService;

public class UserDao {

	private String query;
	private final String url = "jdbc:mysql://localhost:3306/db2";
	private final String uname = "root";
	private final String pass = "Purva123#";

	public List<String> SelectByJob(String jobrole) {
		List<String> ls = new ArrayList<>();
		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			String userData = "";
			query = "select * from user where jobrole = " + jobrole;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4)
						+ " : " + rs.getString(5);
				ls.add(userData);
			}
			if (rs.getFetchSize() == 0)
				ls.add("Not found.");
			st.close();
			con.close();
		} catch (Exception ex) {
			String error = "Exception in fetching data.";
			ls.add(error);
		}
		return ls;
	}

	public List<String> SelectAll() {
		List<String> ls = new ArrayList<>();
		try {
            //System.out.println(0);
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			//System.out.println(0);
			Statement st = con.createStatement();
			String userData = "";
			//System.out.println(0);
			query = "select * from user";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4)
						+ " : " + rs.getString(5);
				ls.add(userData);
			}
			if (rs.getFetchSize() == 0)
				ls.add("Not found.");
			st.close();
			con.close();
		} catch (Exception ex) {
			//System.out.println(ex.getMessage());
			String error = "Exception in fetching .";
			ls.add(error);
		}
		return ls;
	}

	public int Update(User user, int id) {
		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			int count = 0;
			query = "select count(*) from user where id =" + id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			count = rs.getInt("count(*)");
			if (count == 0) {
				return -1;
			}
			query = "delete from user where id = " + id;
			st.executeUpdate(query);
			st.close();

			query = "insert into user values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, id);
			pst.setString(2, user.getName());
			pst.setString(3, user.getJobrole());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhone());
			pst.executeUpdate();

			pst.close();
			con.close();
		} catch (Exception ex) {
			return 0;
		}
		return 1;
	}

	public int Insert(User user) {
		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			query = "insert into user values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getJobrole());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhone());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception ex) {
			return 0;
		}
		return 1;
	}

	public String SelectById(int id) {

		String userData = "";
		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			query = "select * from user where id = " + id;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4)
						+ " : " + rs.getString(5);
			}
			if (rs.getFetchSize() == 0)
				return "Not found.";
			st.close();
			con.close();
		} catch (Exception ex) {
			String error = "Exception in fetching data.";
			return error;
		}
		return userData;
	}

	public int Delete(int id) {

		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			int count = 0;
			query = "select count(*) from user where id =" + id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			count = rs.getInt("count(*)");
			if (count == 0) {
				return -1;
			}
			query = "delete from user where id = " + id;
			st.executeUpdate(query);
			st.close();
			con.close();
			return 1;

		} catch (Exception ex) {
			return 0;
		}
	}

	public String findEmail(int id) {
		String userData = "";
		try {
			Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			query = "select email from user where id = " + id;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userData = rs.getString("email");
			}
			if (rs.getFetchSize() == 0)
				return "Not found.";
			st.close();
			con.close();
		} catch (Exception ex) {
			String error = "Exception in fetching data.";
			return error;
		}
		return userData;
	}
}