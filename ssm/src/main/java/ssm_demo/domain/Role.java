package ssm_demo.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Role {
    private int id;
    private String roleName;
    private String roleDesc;
    private List<User> users;
}
