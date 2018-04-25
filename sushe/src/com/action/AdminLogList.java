package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.LogBean;
import com.dao.LogDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogList extends ActionSupport{
	//������Action�����ڷ�װ�û��������������
	private List<LogBean> list;
	public List<LogBean> getList(){
		return list;
	}
	
	public void setList(List<LogBean> list){
		this.list = list;
	}
	
	private String Building_ID;
	private String Domitory_ID;
	private String Student_Username;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String building_ID) {
		Building_ID = building_ID;
	}

	public String getDomitory_ID() {
		return Domitory_ID;
	}

	public void setDomitory_ID(String domitory_ID) {
		Domitory_ID = domitory_ID;
	}

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String student_Username) {
		Student_Username = student_Username;
	}
	
	//�����û������execute����
	public String execute() throws Exception{
		//������룬����ҳ�����
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</javascript>");
			out.flush();
			out.close();
			return null;
		}
		
		//��ѯ����
		String strWhere = "Student_State='��ס'";
		if(!(isInvalid(Building_ID))){
			strWhere += " and Building_ID"+Building_ID+"'"+Domitory_ID+"'";
		}
		if(!(isInvalid(Domitory_ID))){
			strWhere+=" and Domitory_ID='"+Domitory_ID+"'";
		}
		//��ѯ����
		list = new LogDao().GetList(strWhere, "Log_Date desc");
		return SUCCESS;
	}

	private boolean isInvalid(String value) {
		return (value == null|| value.length()==0);
	}
}
