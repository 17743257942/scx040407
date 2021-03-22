package _5_spring.spring._6mybatis;

import _5_spring.spring._6mybatis.dao.IUserDao;
import _5_spring.spring._6mybatis.domain.Account;
import _5_spring.spring._6mybatis.domain.AccountUser;
import _5_spring.spring._6mybatis.domain.QueryVo;
import _5_spring.spring._6mybatis.domain.User;
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
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        // save
//        User user = new User(11,"asdf",new Date(),"男","xx路xx号");
//        userDao.saveUser(user);
//        session.commit();

        //update
//        User user1 = new User(51,"asdf2",new Date(),"男","xx路xx号");
//        userDao.updateUser(user1);
//        session.commit();

        //delete
//        userDao.deleteUser(51);
//        session.commit();

        //findOne
//        User result = userDao.findOne(41);
//        System.out.println(result);

        //findByName
//        List<User> users = userDao.findByName("%王%");
//        for (User user : users) {
//            System.out.println(user);
//        }

        //findUserByVo
//        User user = new User();
//        user.setUsername("%王%");
//        QueryVo vo = new QueryVo();
//        vo.setUser(user);
//        List<User> users = userDao.findUserByVo(vo);
//        for (User u : users) {
//            System.out.println(u);
//        }

        //findUserByVo2
//        QueryVo vo = new QueryVo();
//        vo.setIds(new ArrayList<>(Arrays.asList(41, 42, 43)));
//        System.out.println(vo);
//        List<User> users = userDao.findUserByVo2(vo);
//        for (User u : users) {
//            System.out.println(u);
//        }

        // select All2
        List<Account> accounts = userDao.findAll2();
        for (Account account : accounts) {
            System.out.println(account);
        }

        // select All3
//        List<AccountUser> accountUsers = userDao.findAll3();
//        for (AccountUser accountUser : accountUsers) {
//            System.out.println(accountUser);
//        }


        session.close();
        in.close();

    }
}
