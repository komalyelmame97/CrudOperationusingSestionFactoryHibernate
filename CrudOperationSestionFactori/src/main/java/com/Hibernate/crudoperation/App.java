package com.Hibernate.crudoperation;

import com.Hibernate.crudoperation.model.Employee;
import com.Hibernate.dao.EmployeeDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao employeedao = new EmployeeDao();
        Employee employee = new Employee("Ankita", 30000);
//        employeedao.saveEmployee(employee);
//        employeedao.updateEmployee("Ankita", 2);
//        employeedao.deleteEmployee(2);
//        employeedao.selectAllEmployee();
        employeedao.selectOneEmployee(3);
    }
}
