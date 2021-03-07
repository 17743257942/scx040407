package _5_spring.spring._0myspring.app;

import _5_spring.spring._0myspring.service.AccountServiceImpl;
import _5_spring.spring._0myspring.service.IAccountService;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
