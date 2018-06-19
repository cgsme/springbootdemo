package com.tutu.springboot;

import com.tutu.springboot.bean.Department;
import com.tutu.springboot.bean.Role;
import com.tutu.springboot.bean.User;
import com.tutu.springboot.repository.DepartmentRepository;
import com.tutu.springboot.repository.RoleRepository;
import com.tutu.springboot.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * mysql数据源测试
 *
 * @author cguisheng
 * @since 2018/6/17 19:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest {

    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData() {
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        roleRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.isNull(department.getId(), "部门ID为空");

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(), "角色ID为空");

        User user = new User();
        user.setName("tutu");
        user.setCreateDate(new Date());
        user.setDepartment(department);
        List<Role> roleList = roleRepository.findAll();
        user.setRoles(roleList);
        userRepository.save(user);
        Assert.notNull(user.getId(), "用户ID为空");
    }

    @Test
    public void findByPage() {
        Pageable pageable = new PageRequest(0, 10,
                new Sort(Sort.Direction.ASC, "id"));
        Page<User> userPage = userRepository.findAll(pageable);
        Assert.notNull(userPage, "用户数据为空");

        for (User user: userPage.getContent()) {
            logger.info("=====user===== 用户名：{}, 部门名：{}, 角色名：{}.",
                    user.getName(), user.getDepartment().getName(),
                    user.getRoles().get(0).getName());
        }
    }
}
