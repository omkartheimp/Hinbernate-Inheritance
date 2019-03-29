package com.scp.java.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.java.app.util.HibernateUtil;
import com.scp.java.dao.EmpDAO;
import com.scp.java.entity.EmpEntity;

@Repository
public class EmpDAOImpl implements EmpDAO {
//	HibernateUtil util =new HibernateUtil();
	
	@Autowired
	SessionFactory sfacotry;

	
	
	@Override
	public boolean insertNewEmp(EmpEntity emp) {
		//SessionFactory sfacotry = util.getSessionFactory();
		Session session = sfacotry.openSession();
		Transaction tr = session.beginTransaction();
		session.save(emp);
		HibernateUtil.saveNFlush(session,tr);
		return false;
	}

	@Override
	public boolean removeEmp(int empId) {
		
		
		EmpEntity dbEntity = fetchEmp(empId);
		if(dbEntity!=null){
	//		SessionFactory sfacotry = util.getSessionFactory();
			Session session = sfacotry.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(dbEntity);
			HibernateUtil.saveNFlush(session,tr);
			return true;
		}else{
			System.out.println("record not exit so cannot delete");
			return false;
		}
	}

	@Override
	public EmpEntity fetchEmp(int empId) {
		//SessionFactory sfacotry = util.getSessionFactory();
		Session session = sfacotry.openSession();
		EmpEntity dbEntity = (EmpEntity) session.get(EmpEntity.class,empId);
		HibernateUtil.saveNFlush(session,null);
		return dbEntity;
	}

	@Override
	public List<EmpEntity> fetchAllEmp() {
		//SessionFactory sfacotry = util.getSessionFactory();
		System.out.println(sfacotry);
		Session session = sfacotry.openSession();
		//Query query = session.createQuery("Select * from emppinfo");
		List<EmpEntity> entities = session.createCriteria(EmpEntity.class).list();
		return entities;
	}
	@Override
	public EmpEntity modifyEmp(EmpEntity bean) {
		EmpEntity dbEntity = fetchEmp(bean.getEmpIdentifier());
		if(dbEntity!=null){
			//SessionFactory sfacotry = util.getSessionFactory();
			Session session = sfacotry.openSession();
			Transaction tr = session.beginTransaction();
			EmpEntity updatedEntity  = (EmpEntity) session.merge(bean);
			HibernateUtil.saveNFlush(session,tr);
			return updatedEntity;
		}else{
			System.out.println("record not exit so cannot update");
			return null;
		}
	}

}
