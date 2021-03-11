package _5_spring.spring._1myspring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Configuration表示当前类是一个配置类
 * ComponentScan自动扫描包
 * Bean把方法返回值放入ioc容器中
 * Import导入其他的配置类
 * PropertySource用于指定properties文件的位置
 */
@Configuration
@ComponentScan(basePackages = "_5_spring.spring._1myspring")
@Import({JDBCConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


}
