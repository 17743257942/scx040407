package ssm_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm_demo.dao.MyDaoMapper;
import ssm_demo.domain.Account;
import ssm_demo.domain.QueryVo;
import ssm_demo.domain.Role;
import ssm_demo.domain.User;
import ssm_demo.service.MyService;

import java.util.List;

@Service("myService")
public class MyServiceImpl implements MyService {

    @Autowired
    private MyDaoMapper dao;

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }

    @Override
    public List<User> findUserByVoUser(QueryVo vo) {
        return dao.findUserByVoUser(vo);
    }

    @Override
    public List<User> findUserByVoIds(QueryVo vo) {
        return dao.findUserByVoIds(vo);
    }

    @Override
    public List<Account> findAllOneToOne() {
        return dao.findAllOneToOne();
    }

    @Override
    public List<User> findAllOneToMore() {
        return dao.findAllOneToMore();
    }

    @Override
    public List<Role> findAllMoreToMore() {
        return dao.findAllMoreToMore();
    }
}
