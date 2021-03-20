package _5_spring.spring._6mybatis.dao;

import _5_spring.spring._6mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
//    @Select("select * from user")
    List<User> findAll();
}
