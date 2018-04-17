package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.BuildingBean;
import com.db.DBHelper;

public class BuildingDao {
	//获取列表
	public List<BuildingBean> GetList(String strwhere, String strorder){
		String sql = "select * from Building";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<BuildingBean> list = new ArrayList<BuildingBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				BuildingBean cnbean = new BuildingBean();
				cnbean.setBuilding_ID(rs.getInt("Building_Id"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setBuilding_Introduction(rs.getString("Building_Introduction"));
				list.add(cnbean);
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
		return list;
	}
	
	//获取指定ID的实体Bean
	public BuildingBean GetBean(int id){
		String sql = "select * from Building where Building_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		BuildingBean cnbean = new BuildingBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setBuilding_ID(rs.getInt("Building_ID"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setBuilding_Introduction(rs.getString("Building_Instroduction"));
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
	public void Add(BuildingBean cnbean){
		String sql = "insert into Building(";
		sql+="Building_Name, Building_Introduction";
		sql+=") values(";
		sql+="'"+cnbean.getBuilding_Name()+"','"+
				cnbean.getBuilding_Introduction()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat=conn.createStatement();
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
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//修改
	public void Update(BuildingBean cnbean){
		String sql = "update Building set ";
		sql += "Building_Name='"+cnbean.getBuilding_Name()+"','";
		sql+="Building_Introduction='"+
				cnbean.getBuilding_Introduction()+"'";
		sql += " where Building_ID='"+cnbean.getBuilding_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat=conn.createStatement();
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
	
	//删除
	public void Delete(String strwhere){
		String sql = "delete Building where ";
		sql+=strwhere;
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
				if(rs!=null)
					rs.close();
				if(stat!=null)
					stat.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	//判断是否为空
	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}
}
