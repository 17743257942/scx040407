package _5_spring.spring._7myspring_frame;

import _5_spring.spring._7myspring_frame.annotation.Component;
import _5_spring.spring._7myspring_frame.annotation.Controller;
import _5_spring.spring._7myspring_frame.annotation.Repository;
import _5_spring.spring._7myspring_frame.annotation.Service;
import _5_spring.spring._7myspring_frame.util.ClassUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
/**
 * bean容器
 */
public class BeanContainer {
    //存放所有被配置标记的目标对象的map
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    //加载bean的注解列表
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);

    //容器是否已经加载过bean
    private boolean loaded = false;


    /**
     * 是否已加载
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * bean实例的数量
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 对外暴露beanMap
     */
    public Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    /**
     * 使用枚举防御反射，序列化反序列化等方式获取对象
     */
    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 获取bean实例
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    /**
     * 扫描加载所有bean
     */
    public synchronized void loadBeans(String packageName) {
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (classSet == null || classSet.isEmpty()) {
            log.warn("extract nothing from packageName: " + packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果类上面标记了定义的注解
                if (clazz.isAnnotationPresent(annotation)) {
                    //将目标类本身作为键，目标类的实例作为值，放入beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }


    public static void main(String[] args) {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("_5_spring.spring._6mybatis.domain");
        Map<Class<?>, Object> map = beanContainer.getBeanMap();
        for (Class<?> k : map.keySet()) {
            System.out.println("key=[" + k + "],value=[" + map.get(k) + "]");
        }
    }
}
