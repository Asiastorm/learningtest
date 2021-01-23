package com.huawei.rsp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRsp {
    private Boolean isValid;
    private String token;
}
