package com.huawei.Dao.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * student
 * @author 
 */
@Getter
@Setter
public class Student{
    private String id;

    @JsonProperty("sno")
    private String studentId;

    private Long klassId;

    private String name;
}