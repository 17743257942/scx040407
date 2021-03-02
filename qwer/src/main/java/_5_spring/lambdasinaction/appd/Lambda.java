package _5_spring.lambdasinaction.appd;

import java.util.function.Function;

public class Lambda {

    Function<Object, String> f = obj -> obj.toString();
}
