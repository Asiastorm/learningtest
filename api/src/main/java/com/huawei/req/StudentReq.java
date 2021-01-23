package com.huawei.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.Dao.model.Klass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * student
 *
 * @author
 */
@Data
public class StudentReq {
    private String id;

    @JsonProperty("sno")
    private Long studentId;

    private Klass klass;

    private String name;
}