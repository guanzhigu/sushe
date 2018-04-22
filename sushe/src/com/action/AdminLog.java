package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.BuildingBean;
import com.bean.DomitoryBean;
import com.dao.BuildingDao;
import com.dao.DomitoryDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLog extends ActionSupport{
	
	//������Action�����ڷ�װ�û��������������
	private List<BuildingBean> buildingList;
	private List<DomitoryBean> domitoryList;
	public List<BuildingBean> getBuildingList() {
		return buildingList;
	}
	public void setBuildingList(List<BuildingBean> buildingList) {
		this.buildingList = buildingList;
	}
	public List<DomitoryBean> getDomitoryList() {
		return domitoryList;
	}
	public void setDomitoryList(List<DomitoryBean> domitoryList) {
		this.domitoryList = domitoryList;
	}
	
	private String BuildingID;
	private String DomitoryID;
	public String getBuildingID() {
		return BuildingID;
	}
	public void setBuildingID(String buildingID) {
		BuildingID = buildingID;
	}
	public String getDomitoryID() {
		return DomitoryID;
	}
	public void setDomitoryID(String domitoryID) {
		DomitoryID = domitoryID;
	}
	
	//�����û������execute����
	public String execute() throws Exception{
		
		//������룬����ҳ�����
		HttpServletResponse response = null;
		response= ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.loaction='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		
		//��ѯ¥��
		buildingList = new  BuildingDao().GetList("", "Building_Name");
		
		//��ѯ����
		String strwhere = "1=1";
		if(!(isInvalid(BuildingID))){
			strwhere += " and Domitory_BuildingID='"+BuildingID+"'";
		}else{
			strwhere+=" and 1=2";
		}
		
		//��ѯ����
		domitoryList = new DomitoryDao().GetList(strwhere, "Domitory_Name");
		
		return SUCCESS;
		
	}
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null||value.length()==0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
