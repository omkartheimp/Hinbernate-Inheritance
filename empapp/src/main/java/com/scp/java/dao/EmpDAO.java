package com.scp.java.dao;

import java.util.List;

import com.scp.java.entity.EmpEntity;

public interface EmpDAO {
	public boolean insertNewEmp(EmpEntity bean);
	public boolean removeEmp(int empId);
	public EmpEntity fetchEmp(int empId);
	public List<EmpEntity> fetchAllEmp();
	public EmpEntity modifyEmp(EmpEntity bean);

	
}


/**
Produce
	Apache Jersey --
	Rest easy
	Spring REST ---
	Apache CXF

Consume
	Apache JerSey ClientBuilder --
	HTTPClient --
	RESTAssured --
	net URl
	Spring REST Template --

*/