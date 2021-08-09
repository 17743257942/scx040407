package _5_spring.spring._7myspring_frame.inject;

import _5_spring.spring._7myspring_frame.BeanContainer;

public class DependencyInjector {
    private BeanContainer beanContainer;
    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC
     */
    public void doIOC() {
        //1.遍历Bean容器中所有的Class对象

        //2.遍历Class对象的所有成员变量
        //3.找出被AutoWired标记的成员变量
        //4.获取成员变量的类型
        //5.获取成员变量的类型在容器里对应的实例
        //6.通过反射将对应的成员变量实例注入到类实例
    }

}
