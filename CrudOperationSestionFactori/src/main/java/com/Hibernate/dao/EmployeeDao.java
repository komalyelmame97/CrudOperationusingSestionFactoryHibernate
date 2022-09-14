package com.Hibernate.dao;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Hibernate.crudoperation.model.Employee;
import com.Hibernate.util.EmployeeUtil;

public class EmployeeDao {

	public void saveEmployee(Employee employee)
	{
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(employee);
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee(String ename,int eid)
	{
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q = session.createQuery("Update Employee set ename =: ename where eid =: eid");
			q.setParameter("ename",ename);
			q.setParameter("eid",eid);
			int i = q.executeUpdate();
			if(i>0)
			{
				System.out.println("Update Query successfully..");
			}
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public void deleteEmployee(int eid)
	{
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q = session.createQuery("delete from Employee where eid =: eid");
			q.setParameter("eid",eid);
			int i = q.executeUpdate();
			if(i>0)
			{
				System.out.println("Deleted Record.");
			}
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public void selectAllEmployee()
	{
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q = session.createQuery("from Employee");
			
			List<Employee> le = q.list();
			for(Employee e : le)
			{
				System.out.println("Employee eid: " + e.getEid() + "\nEmployee name: " + e.getEname()+ "\nEmployee salary: " +e.getEsalary());
			}
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public void selectOneEmployee(int eid)
	{
		Transaction trans = null;
		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q = session.createQuery("from Employee where eid =: id");
			q.setParameter("id",eid);
			List<Employee> le = q.list();
			for(Employee e : le)
			{
				System.out.println("Employee eid: " + e.getEid() + " Employee name: " + e.getEname()+ " Employee salary: " +e.getEsalary());
			}
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	
}
