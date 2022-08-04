package com.beyondsoft.sprintbootdemo1.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user") //指定表名，默认为实体类的名字
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    private String password;
    private String email;
    private Date birthday;
}
