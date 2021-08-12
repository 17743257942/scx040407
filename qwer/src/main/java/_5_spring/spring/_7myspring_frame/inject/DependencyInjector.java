package _5_spring.spring._7myspring_frame.inject;

import _5_spring.spring._7myspring_frame.BeanContainer;
import _5_spring.spring._7myspring_frame.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.Set;

public class DependencyInjector {
    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC
     */
    public void doIOC() {
        Set<Class<?>> classSet = beanContainer.getClasses();
        if (ClassUtil.isEmpty(classSet)) {
            return;
        }
        //1.遍历Bean容器中所有的Class对象
        for (Class<?> clazz : classSet) {
            //2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getFields();
            if (ClassUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                //3.找出被AutoWired标记的成员变量
                if (field.isAnnotationPresent(AutoWired.class)) {
                    AutoWired autoWired = field.getAnnotation(AutoWired.class);
                    String autoWiredValue = autoWired.value();
                    //4.获取成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取成员变量的类型在容器里对应的实例
                    Object fieldValue = beanContainer.getFieldInstance(fieldClass, autoWiredValue);
                    if (fieldValue == null) {
                        throw new RuntimeException("error 5.获取成员变量的类型在容器里对应的实例 为空");
                    } else {
                        //6.通过反射将对应的成员变量实例注入到类实例
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }

                }
            }
        }
    }

}
