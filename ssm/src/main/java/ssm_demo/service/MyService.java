package ssm_demo.service;

import ssm_demo.domain.*;

import java.util.List;

public interface MyService {
    List<User> findAll();

    User findOne(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    List<User> findUserByVoUser(QueryVo vo);

    List<User> findUserByVoIds(QueryVo vo);

    List<Account> findAllOneToOne();

    List<User> findAllOneToMore();

    List<Role> findAllMoreToMore();
}
