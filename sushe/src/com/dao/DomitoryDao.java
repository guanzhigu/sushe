package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.DomitoryBean;
import com.db.DBHelper;

public class DomitoryDao {
	//获取列表
	public List<DomitoryBean> GetList(String strwhere, String strorder){
		String sql ="select * from Domitory, Building where Domitory_BuildingID =Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+= " order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DomitoryBean> list = new ArrayList<DomitoryBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DomitoryBean cnbean = new DomitoryBean();
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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
	public DomitoryBean GetBean(int id){
		String sql = "select * from Domitory, " +
				"Building where Domitory_BuildingId = " +
				"Building_ID and Domitory_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DomitoryBean cnbean = new DomitoryBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Number("Domitory_Number");
				cnbean.setDomitory_Type(rs.getString("Domiotry_Type"));
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
		}catch(SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		return cnbean;
	}
	
	//添加
	public void Add(DomitoryBean cnbean){
		String sql ="insert into Domitory (";
		sql += "Domitory_BuildingID, Domitory_Name, Domitory_Type, Domitory_Number, Domitory_Tel";
		sql+= ")values(";
		sql+="'"+cnbean.getDomitory_BuildingID()+"','"+cnbean.getDomitory_Name()+"','"+
		cnbean.getDomitory_Type()+"','"+cnbean.getDomitory_Number()+"','"+
				cnbean.getDomitory_Tel()+"'";
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
	public void Update(DomitoryBean cnbean){
		String sql = "update Domitory set ";
		sql+="Domitory_BuildingID='"+cnbean.getDomitory_BuildingID()+"',";
		sql+="Domitory_Name='"+cnbean.getDomitory_Name()+"',";
		sql+="Domitory_Type='"+cnbean.getDomitory_Type()+"',";
		sql+="Domitory_Number='"+cnbean.getDomitory_Number()+"',";
		sql+="Domitory_Tel='"+cnbean.getDomitory_Tel()+"'";
		sql+="where Domitory_ID='"+cnbean.getDomitory_ID()+"'";
		
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
	
	//删除
	public void Delete(String strwhere){
		String sql = "delete Domitory where ";
		sql+=strwhere;
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
	
	//判断是否为空值
	private boolean isInvalid(String strwhere) {
		// TODO Auto-generated method stub
		return (strwhere.length() ==0 | strwhere==null);
	}
	
	//测试
	public static void main(String[] args){
		System.out.println("");
	}
}
