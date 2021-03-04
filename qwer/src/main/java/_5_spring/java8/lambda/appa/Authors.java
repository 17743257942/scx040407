package _5_spring.java8.lambda.appa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {

    Author[] value();

}
