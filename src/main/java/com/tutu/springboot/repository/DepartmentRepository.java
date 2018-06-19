package com.tutu.springboot.repository;

import com.tutu.springboot.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门持久化接口
 *
 * @author cguisheng
 * @since 2018/6/17 17:23
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
