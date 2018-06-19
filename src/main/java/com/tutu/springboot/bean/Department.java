package com.tutu.springboot.bean;

import javax.persistence.*;

/**
 * 部门
 *
 * @author cguisheng
 * @since 2018/6/17 16:37
 */
@Entity
@Table(name = "department")
public class Department {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
