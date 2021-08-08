

import _5_spring.spring._7myspring_frame.BeanContainer;
import _5_spring.spring._7myspring_frame.util.ClassUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.Set;

public class Test1 {
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("_5_spring.spring._6mybatis.domain");
        System.out.println(classSet);
    }



    private static BeanContainer beanContainer;
    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }
    @Test
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("");
    }


}
