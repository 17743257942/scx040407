package _5_spring.spring._6mybatis.domain;

import _5_spring.spring._7myspring_frame.annotation.Controller;
import _5_spring.spring._7myspring_frame.annotation.Repository;
import _5_spring.spring._7myspring_frame.inject.AutoWired;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class User implements Serializable {
    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @AutoWired
    private Integer id;
    @AutoWired
    private String username;
    @AutoWired
    private Date birthday;
    @AutoWired
    private String sex;
    @AutoWired
    private String address;
    @AutoWired
    List<Account> accounts;
}
