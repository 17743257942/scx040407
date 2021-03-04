package _5_spring.java8._0mytest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        final IProducer producer = new ProducerImpl();
        IProducer producer2 = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        if ("saleProduct".equals(method.getName())) {
                            result = method.invoke(producer, (Float) args[0] * 0.8f);
                        }
                        return result;
                    }
                });

        producer.saleProduct(1000f);
        producer2.saleProduct(1000f);

    }
}
