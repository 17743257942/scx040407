package ssm_demo.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryVo {
    private User user;
    private List<Integer> ids;
}
