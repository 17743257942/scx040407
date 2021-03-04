package _5_spring.java8._0mytest.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {

        final IProducer producer = new ProducerImpl();
        IProducer producer2 = (IProducer) Enhancer.create(producer.getClass(),
                new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                if ("saleProduct".equals(method.getName())) {
                    result = method.invoke(producer, (Float) objects[0] * 0.8f);
                }
                return result;
            }
        });
        producer.saleProduct(1000);
        producer2.saleProduct(1200);
    }
}
