package com.scp.java.service;

import java.util.List;

import com.scp.java.bean.EmpBean;

public interface EmpService {
	
	public boolean addEmp(EmpBean bean);
	public boolean deleteEmp(int empId);
	public EmpBean getEmp(int empId);
	public List<EmpBean> getAllEmp();
	public EmpBean updateEmp(EmpBean bean);

}
