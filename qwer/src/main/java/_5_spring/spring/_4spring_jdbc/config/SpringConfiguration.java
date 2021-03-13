package _5_spring.spring._4spring_jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration表示当前类是一个配置类
 * ComponentScan自动扫描包
 * Bean把方法返回值放入ioc容器中
 * Import导入其他的配置类
 * PropertySource用于指定properties文件的位置
 */
@Configuration
@ComponentScan(basePackages = "_5_spring.spring._4spring_jdbc")
@Import({JDBCConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


}
