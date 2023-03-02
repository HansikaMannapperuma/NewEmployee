package com.example.Payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM user WHERE id=?1",nativeQuery = true)
    Employee getEmployeeByEmployeeId(String userId);

    @Query(value = "SELECT * FROM user WHERE id=?1 AND address=?2",nativeQuery = true)
    Employee getEmployeeByEmployeeIdAndAddress(int userId, String address);
}
