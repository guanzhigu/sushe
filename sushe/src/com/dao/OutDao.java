package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.LogBean;
import com.db.DBHelper;

public class OutDao {
	//Ìí¼Ó
		public void Add(LogBean cnbean){
			String sql="insert into Log (";
			sql+="Log_StudentID,Log_TeacherID,Log_Date,Log_Remark";
			sql+=") values(";
			sql+="'"+cnbean.getLog_StudentID()+"','"+cnbean.getLog_TeacherID()+"','"+cnbean.getLog_Date()+"','"+cnbean.getLog_Remark()+"'";
			sql+=")";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//ÐÞ¸Ä
		public void Update(LogBean cnbean){
			String sql="update Log set ";
			sql+="Log_StudentID='"+cnbean.getLog_StudentID()+"',";
			sql+="Log_TeacherID='"+cnbean.getLog_TeacherID()+"',";
			sql+="Log_Date='"+cnbean.getLog_Date()+"',";
			sql+="Log_Remark='"+cnbean.getLog_Remark()+"'";
			
			sql+=" where Log_ID='"+cnbean.getLog_ID()+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//É¾³ý
		public void Delete(String strwhere){
			String sql="delete Log where ";
			sql+=strwhere;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//ÅÐ¶ÏÊÇ·ñ¿ÕÖµ
		@SuppressWarnings("unused")
		private boolean isInvalid(String strwhere) {
			return (strwhere == null || strwhere.length() == 0);
		}
		
		//²âÊÔ
		public static void main(String[] args) {
			System.out.println("");
		}
}
