package _5_spring.spring._6mybatis;

import _5_spring.spring._6mybatis.dao.IUserDao;
import _5_spring.spring._6mybatis.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        testCRUD();
    }

    private static void demo() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }


    public static void testCRUD() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        // select All
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("=======testCRUD==========");
        // save
//        User user = new User(11,"asdf",new Date(),"男","xx路xx号");
//        userDao.saveUser(user);
//        session.commit();

        //update
//        User user1 = new User(49,"asdf2",new Date(),"男","xx路xx号");
//        userDao.updateUser(user1);
//        session.commit();

        //delete
//        userDao.deleteUser(49);
//        session.commit();

        //findOne
//        User result = userDao.findOne(41);
//        System.out.println(result);

        //findByName
        List<User> users2 = userDao.findByName("%王%");
        for (User user : users2) {
            System.out.println(user);
        }
        System.out.println("=======findByName==========");

        //findUserByVo
        User user = new User();
        user.setUsername("%王%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> users3 = userDao.findUserByVo(vo);
        for (User u : users3) {
            System.out.println(u);
        }
        System.out.println("=======findUserByVo==========");

        //findUserByVo2
        QueryVo vo2 = new QueryVo();
        vo.setIds(new ArrayList<>(Arrays.asList(41, 42, 43)));
        System.out.println(vo);
        List<User> users4 = userDao.findUserByVo2(vo);
        for (User u : users4) {
            System.out.println(u);
        }
        System.out.println("=======findUserByVo2==========");

        // select All2
        List<Account> accounts = userDao.findAll2();
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("======select All2===========");

        // select All3
        List<AccountUser> accountUsers = userDao.findAll3();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
        System.out.println("======select All3===========");

        // select All4
        List<User> users5 = userDao.findAll4();
        for (User u : users5) {
            System.out.println(u);
        }
        System.out.println("=======select All4==========");

        // select All5
        List<Role> roles = userDao.findAll5();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println("======select All5===========");

        session.close();
        in.close();

    }
}
