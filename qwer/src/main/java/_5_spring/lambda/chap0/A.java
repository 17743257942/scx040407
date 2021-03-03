package _5_spring.lambda.chap0;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder //可以任意多个构造
@Getter
@Setter
//@Value 只公开getter不能setter，所以不能和builder共存
public class A {

    private int age;

    private String name;

    public static void main(String[] args) {
        A a = A.builder().name("asdf").build();
        A a1 = A.builder().age(11).build();
        System.out.println(a);
        System.out.println(a1);
    }

}
