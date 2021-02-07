package com.example.employee.employee.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.employee.employee.Model.Employee;


@Mapper
public interface EmployeeMapper {
	
	//@Select("select * from employee")
     List<Employee> findAll();
	
	/*@Insert("insert into employee(Name, Address,Designation,DateOfBirth) values(#{Name}, #{Address}, #{Designation},#{DateOfBirth})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
    	    before = false, resultType = Integer.class)*/
	void insert(Employee employee);
	
	//@Update("update employees set Name=#{Name}, Address=#{Address},Designation=#{Designation},DateOfBirth=#{DateOfBirth} where id=#{id}")
	 void update(Employee employee);
	
	//@Select("SELECT Name,Address,Designation,DateOfBirth from employee WHERE id = #{id}")
	Employee getById(int id);
	
	
	//@Delete("delete from employees where id=#{id}")
	public void delete(Employee employee);
}
