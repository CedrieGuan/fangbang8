package com.fangbang8.client.entity;

public class School {
//	自增Id
	private int id ;
//学校名
	private String name ;
	//所在省份
	private String province ;
//	等级
	private String grade ;
//	序号
	private String number ;
	//是否收藏了  0无1有
	private String collect ="0";
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the collect
	 */
	public String getCollect() {
		return collect;
	}
	/**
	 * @param collect the collect to set
	 */
	public void setCollect(String collect) {
		this.collect = collect;
	}


}
