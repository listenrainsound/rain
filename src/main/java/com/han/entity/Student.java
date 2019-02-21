package com.han.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.han.utils.DateDeserialize;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Student {

    //id自增
    @Id
    // @GeneratedValue//设置为自增
    //或者使用
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserialize.class)
    @Column(name = "JOINDATE")
    private Date joinDate;

    @Column(name = "SEX")
    //0男,1女
    private Integer sex;
}
