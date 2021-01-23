package com.huawei.Dao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * teacher
 * @author
 */
@Data
public class Teacher implements Serializable {
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 0男，1女
     */
    private boolean sex;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}