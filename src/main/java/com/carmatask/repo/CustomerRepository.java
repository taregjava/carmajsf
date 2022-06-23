package com.carmatask.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carmatask.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select cus from Customer cus where cus.email=:email")
	public Customer findByEmail(@Param("email") String email);
	
	@Query("select cus from Customer cus order by cus.email")
	public List<Customer> lstAll();

}
