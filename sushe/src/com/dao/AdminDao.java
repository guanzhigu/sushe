package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.AdminBean;
import com.db.DBHelper;

public class AdminDao {

	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql = "select * from Admin where Admin_Username='"+username+
				"' and Admin_Password='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				id = rs.getString("Admin_ID");
			}
		}catch(SQLException ex){}
		return id;
	}
	
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql = "select * from Admin where Admin_ID='"+id+
				"' and Admin_Password="+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ps = true;
			}
		}catch(SQLException ex){}
		return ps;
	}
	
	//获取列表
	public List<AdminBean> GetList(String strWhere, String strorder){
		String sql = "select * from Admin";
		if(!(isInvalid(strWhere)))
		{
			sql += " where "+strWhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql += " order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<AdminBean> list = new ArrayList<AdminBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				AdminBean cnbean = new AdminBean();
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Username"));
				cnbean.setAdmin_Password(rs.getString("Admin_password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));
				list.add(cnbean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(conn != null)
					conn.close();
				if(stat != null)
					stat.close();
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value==null||value.length()==0);
	}
	
	//获取指定ID的实体Bean
	public AdminBean GetBean(int id){
		String sql = "select * from Admin where Admin_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		AdminBean cnbean = new AdminBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));
			}
		}catch(SQLException e){
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
		return cnbean;
	}
	
	//添加
	public void Add(AdminBean cnbean){
		String sql = "insert into Admin(";
		sql+="Admin_Username, Admin_Password, " +
				"Admin_Name, Admin_Sex, Admin_Tel";
		sql += ") values(";
		sql	+= "'"+cnbean.getAdmin_Username()+","+
		cnbean.getAdmin_Password()+","+
		cnbean.getAdmin_Name()+"','"+cnbean.getAdmin_Sex()+"','"+
		cnbean.getAdmin_Tel()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(SQLException e){
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
		}
		
		//修改
		public void Update (AdminBean cnbean){
			String sql = "update Admin set ";
			sql+="Admin_Username='"+cnbean.getAdmin_Username()+"','";
			sql+="Admin_Password='"+cnbean.getAdmin_Password()+"','";
			sql+="Admin_Name='"+cnbean.getAdmin_Name()+"','";
			sql+="Admin_Sex='"+cnbean.getAdmin_Sex()+"','";
			sql+="Admin_Tel='"+cnbean.getAdmin_Tel()+"','";
			sql+=" where Admin_ID='"+cnbean.getAdmin_ID()+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeQuery(sql);
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(conn!=null)
						conn.close();
					if(stat!=null)
						stat.close();
					if(rs!=null)
						rs.close();
				}catch(SQLException e)
				{
					e.printStackTrace();				
				}
			}
		}
		
		//删除
		public void Delete(String strwhere){
			String sql = "delete Admin where ";
			sql+=strwhere;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
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
		
		//测试
		public static void main(String[] args){
			System.out.println("");
		}
}
