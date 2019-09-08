package com.test.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.app.model.Employee;

public interface ProductRepository extends JpaRepository<Employee, Long> {

}
