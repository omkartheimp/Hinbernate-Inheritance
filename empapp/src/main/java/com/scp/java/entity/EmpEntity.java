package com.scp.java.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emppinfo")
public class EmpEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empIdentifier;
	private String empFullName;
	private String empCity;
	private double empTakeHomeSal;
	public int getEmpIdentifier() {
		return empIdentifier;
	}
	public void setEmpIdentifier(int empIdentifier) {
		this.empIdentifier = empIdentifier;
	}
	public String getEmpFullName() {
		return empFullName;
	}
	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public double getEmpTakeHomeSal() {
		return empTakeHomeSal;
	}
	public void setEmpTakeHomeSal(double empTakeHomeSal) {
		this.empTakeHomeSal = empTakeHomeSal;
	}
	@Override
	public String toString() {
		return "EmpEntity [empIdentifier=" + empIdentifier + ", empFullName="
				+ empFullName + ", empCity=" + empCity + ", empTakeHomeSal="
				+ empTakeHomeSal + "]";
	}
	
	
	
	
	

}
