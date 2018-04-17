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
	
	private boolean isInvalid(String strwhere) {
		// TODO Auto-generated method stub
		return (strwhere.length() ==0 | strwhere==null);
	}
}
