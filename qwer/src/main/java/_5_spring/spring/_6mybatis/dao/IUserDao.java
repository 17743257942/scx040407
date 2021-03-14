package _5_spring.spring._6mybatis.dao;

import _5_spring.spring._6mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
