package _5_spring.spring._1myspring.app;

import _5_spring.spring._1myspring.dao.IAccountDao;
import _5_spring.spring._1myspring.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解：
 * 用于创建对象的<bean>
 *     Component 作用是把当前类对象存入spring容器中 属性是value用于指定bean的id默认值是类名且首字母小写
 *     Controller Service Repository 作用和属性与Component一样
 * 用于注入数据的<property>
 *     Autowired按先类型后名称注入属性(不需要set方法了)
 *     Qualifier属性是value指定bean的id 给属性不能单独属性 给方法可以
 *     Resource直接按bean的id注入，可以独立使用，属性是name用于指定bean的id
 * 用于改变作用范围的<scope>
 * 和生命周期相关的<init-method><destroy-method>
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("mybeans2.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
//        System.out.println(as);
        System.out.println(adao);
        ac.close();


    }
}
