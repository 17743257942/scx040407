package _5_spring.java8._0mytest.proxy;

public class ProducerImpl implements IProducer {

    @Override
    public void saleProduct(float money) {
        System.out.println("收到了钱" + money + "，交货!!");
    }

}
