package _5_spring.spring._4spring_jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


//@NoArgsConstructor
//@AllArgsConstructor
@Data
@ToString
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;
}


