package com.learning.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.learning.model.Customer;

public class CustomerDao implements ICustomer {
	JdbcTemplate jTemplate;
	
	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	@Override
	public Boolean saveCustomer(Customer customer) {
		String sql = "insert into Customer(cust_id,name,age)"
				+ " values("+customer.getCust_id()+",'"+customer.getName()+"',"+customer.getAge()+");";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return null;
		
	}

	@Override
	public List<Customer> viewCustomers() {
		this.jTemplate.query("Select * from Customer", new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				Customer m = new Customer();
				m.setAge(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setAge(rs.getInt(3));
				return m;
			}
		});
		return null;
	}
}
