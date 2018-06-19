package com.tutu.springboot.repository;

import com.tutu.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户持久化接口
 *
 * @author cguisheng
 * @since 2018/6/17 16:53
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
