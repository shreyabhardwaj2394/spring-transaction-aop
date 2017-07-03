package com.spring.demo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class EmployeeService {

    private JdbcTemplate jdbcTemplate;

    private EmployeeService2 employeeService2;

    public EmployeeService2 getEmployeeService2() {
        return employeeService2;
    }

    public void setEmployeeService2(EmployeeService2 employeeService2) {
        this.employeeService2 = employeeService2;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertEmployee() throws InterruptedException {
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter",27});
        try {
            employeeService2.insertEmployee();

        }catch (Exception e) {

        }
        try {

            employeeService2.insertEmployee2();
        }catch (Exception e) {

        }
    }
}