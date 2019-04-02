package com.scp.java.HibernateInheritance;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestInheritance 
{
    public static void main( String[] args )
    {
     
    	Parent p1=new Parent(10, "Ajya", "Maharashtra");
    	Child c1=new Child(10, "ajya", "Maharashtra", "Karad", 154154);
    	
    	Parent p2=new Parent(15, "pinya", "Maharashtra");
    	Child c2=new Child(15, "pinya", "Maharashtra", "Sangli", 416416);
    
    	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     Transaction tr=session.beginTransaction();
     
     
     
     session.save(p1);
     session.save(c1);
     session.save(p2);
     session.save(c2);
     
     session.flush();
     tr.commit();
    }
}
