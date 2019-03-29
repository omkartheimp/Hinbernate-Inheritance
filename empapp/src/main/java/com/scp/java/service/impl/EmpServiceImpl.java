package com.scp.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.java.bean.EmpBean;
import com.scp.java.dao.EmpDAO;
import com.scp.java.entity.EmpEntity;
import com.scp.java.service.EmpService;

@Service
public class EmpServiceImpl  implements EmpService{

	@Autowired
	EmpDAO empDao;
	
	@Override
	public boolean addEmp(EmpBean bean) {
		return empDao.insertNewEmp(convertBeanToEntity(bean));
	}

	@Override
	public boolean deleteEmp(int empId) {
		return empDao.removeEmp(empId);
	}

	@Override
	public EmpBean getEmp(int empId) {
		return convertEntityToBean(empDao.fetchEmp(empId));
	}

	@Override
	public List<EmpBean> getAllEmp() {
		return convertEntitiesToBeans(empDao.fetchAllEmp());
	}

	@Override
	public EmpBean updateEmp(EmpBean bean) {
	/*		EmpEntity et = convertBeanToEntity(bean);
			EmpEntity enty = empDao.modifyEmp(et);
			return convertEntityToBean(enty);*/
		return convertEntityToBean(empDao.modifyEmp(convertBeanToEntity(bean)));
	}

	private EmpEntity convertBeanToEntity(EmpBean bean){
		EmpEntity entity = new EmpEntity();
		entity.setEmpIdentifier(bean.getEmpId());
		entity.setEmpFullName(bean.getEmpName());
		entity.setEmpCity(bean.getEmpAddress());
		entity.setEmpTakeHomeSal(bean.getSalary());
		return entity;
	}
	
	private EmpBean convertEntityToBean(EmpEntity entity){
		EmpBean bean = new EmpBean();
		bean.setEmpId(entity.getEmpIdentifier());
		bean.setEmpName(entity.getEmpFullName());
		bean.setSalary(entity.getEmpTakeHomeSal());
		bean.setEmpAddress(entity.getEmpCity());
		return bean;
	}
	
	private List<EmpBean> convertEntitiesToBeans(List<EmpEntity> entities){
		List<EmpBean> beans = new ArrayList<EmpBean>();
		for (EmpEntity entity : entities) {
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}

}
