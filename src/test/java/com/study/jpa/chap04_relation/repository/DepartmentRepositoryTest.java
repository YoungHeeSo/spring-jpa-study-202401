package com.study.jpa.chap04_relation.repository;

import com.study.jpa.chap04_relation.entity.Department;
import com.study.jpa.chap04_relation.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
@Transactional
class DepartmentRepositoryTest {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    @DisplayName("양방향 연관관계에서 연관데이터 수정")
    void changeDeptTest() {
        //given

        // 3번 사원의 부서를 2번 부서에서 1번으로 수정해야 하는 상황

        Employee employee = employeeRepository.findById(3L).orElseThrow();

        Department department = departmentRepository.findById(1L).orElseThrow();

        //when

        // tbl_emp 테이블에서 dept_id를 변경하는 것이 논리적으로 맞다
        // 핵심!! ) 양방향에서는 반대편도 같이 수정해줘야 함

        employee.setDepartment(department);
        employeeRepository.save(employee);

        department.getEmployees().add(employee);

        //then

        // 부서를 변경한 상태에서 department 테이블에 1번 부서 사원을 조회한다면?

        List<Employee> employees = department.getEmployees();
        System.out.println("\n\n\n");
        System.out.println("employees = " + employees);
        System.out.println("\n\n\n");
    }

    @Test
    @DisplayName("특정 부서를 조회하면 해당 부서원들도 함께 조회된다")
    void findDeptTest() {
        //given
        Long id = 1L;
        //when
        Department department = departmentRepository.findById(id).orElseThrow();
        //then
        System.out.println("\n\n\n");
        System.out.println("department = " + department);
        System.out.println("department = " + department.getEmployees());
        System.out.println("\n\n\n");
    }
}