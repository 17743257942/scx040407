package _5_spring.spring._3myspring.config;

import org.springframework.context.annotation.*;

/**
 * Configuration表示当前类是一个配置类
 * ComponentScan自动扫描包
 * Bean把方法返回值放入ioc容器中
 * Import导入其他的配置类
 * PropertySource用于指定properties文件的位置
 * EnableAspectJAutoProxy允许切面注解
 */
@Configuration
@ComponentScan(basePackages = "_5_spring.spring._3myspring")
@EnableAspectJAutoProxy
public class SpringConfiguration {


}
