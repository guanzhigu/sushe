package com.bean;

public class TBBean {
	private int TB_ID;
	private int TB_TeacherID;
	private int TB_BuildingID;
	
	private String Teacher_Name;
	private String Teacher_Sex;
	private String Teacher_Tel;
	
	private String Teacher_Username;
	private String Building_Name;
	
	public String getTeacher_Username() {
		return Teacher_Username;
	}
	public void setTeacher_Username(String teacher_Username) {
		Teacher_Username = teacher_Username;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}
	public int getTB_ID() {
		return TB_ID;
	}
	public void setTB_ID(int tB_ID) {
		TB_ID = tB_ID;
	}
	public int getTB_TeacherID() {
		return TB_TeacherID;
	}
	public void setTB_TeacherID(int tB_TeacherID) {
		TB_TeacherID = tB_TeacherID;
	}
	public int getTB_BuildingID() {
		return TB_BuildingID;
	}
	public void setTB_BuildingID(int tB_BuildingID) {
		TB_BuildingID = tB_BuildingID;
	}
	
	
	public String getTeacher_Name() {
		return Teacher_Name;
	}
	public void setTeacher_Name(String teacher_Name) {
		Teacher_Name = teacher_Name;
	}
	public String getTeacher_Sex() {
		return Teacher_Sex;
	}
	public void setTeacher_Sex(String teacher_Sex) {
		Teacher_Sex = teacher_Sex;
	}
	public String getTeacher_Tel() {
		return Teacher_Tel;
	}
	public void setTeacher_Tel(String teacher_Tel) {
		Teacher_Tel = teacher_Tel;
	}
	
}
