package _5_spring.spring._6mybatis.domain;

import lombok.Data;
import lombok.ToString;

@Data
public class AccountUser extends Account {
    private String username;
    private String address;

    @Override
    public String toString() {
        return super.toString() + "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
