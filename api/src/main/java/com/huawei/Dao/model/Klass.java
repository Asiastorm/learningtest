package com.huawei.Dao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * klass
 * @author 
 */
@Data
public class Klass implements Serializable {
    private Long id;

    private String name;

    private Teacher teacher;

    private static final long serialVersionUID = 1L;
}