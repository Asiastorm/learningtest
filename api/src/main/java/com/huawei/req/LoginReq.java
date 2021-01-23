package com.huawei.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginReq {
    @NotBlank
    @Size(max = 32)
    private String username;

    @Size(min = 8,max = 32)
    private String password;
}
