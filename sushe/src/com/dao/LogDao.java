package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.LogBean;
import com.db.DBHelper;

public class LogDao {

	//��ȡ�б�
	public List<LogBean> GetList(String strwhere, String strorder){
		String sql = "select * from Log, Teacher, Student, Domitory, Building where "
				+ "Log_TeacherID=Teacher_ID and Log_StudentID = Student_ID and "
				+ "Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID";
		if(!(isInvalid(strwhere))){
			sql+="and "+strwhere;
		}
		if(!(isInvalid(strorder))){
			sql+=" and "+strorder;
		}
		
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<LogBean> list = new ArrayList<LogBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				LogBean cnbean = new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
				if(stat!=null)
					stat.close();
				if(rs!=null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//����
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
		//�޸�
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
		//ɾ��
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
		
	//�ж��Ƿ��ֵ
	public boolean isInvalid(String value){
		return (value == null || value.length() == 0);
	}
			
	//����
	public static void main(String[] args) {
		System.out.println("");
	}

}
