package _5_spring.spring._6mybatis.dao;

import _5_spring.spring._6mybatis.domain.QueryVo;
import _5_spring.spring._6mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    //    @Select("select * from user")
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findOne(Integer id);

    List<User> findByName(String name);

    List<User> findUserByVo(QueryVo vo);
}
