

import _5_spring.spring._7myspring_frame.util.ClassUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class Test1 {
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("_5_spring.spring._6mybatis.domain");
        System.out.println(classSet);
    }
}
