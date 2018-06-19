package com.tutu.springboot.repository;

import com.tutu.springboot.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色持久化接口
 *
 * @author cguisheng
 * @since 2018/6/17 17:25
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
