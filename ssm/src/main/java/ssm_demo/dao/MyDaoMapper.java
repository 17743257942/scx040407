package ssm_demo.dao;

import org.springframework.stereotype.Repository;
import ssm_demo.domain.Account;
import ssm_demo.domain.QueryVo;
import ssm_demo.domain.Role;
import ssm_demo.domain.User;

import java.util.List;

@Repository
public interface MyDaoMapper {
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
