package com.huawei.rsp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRsp<T> {
    T data;
    String code;

    public BaseRsp(T data) {
        this.data = data;
    }

    public BaseRsp(T data, String code) {
        this.data = data;
        this.code = code;
    }
}
