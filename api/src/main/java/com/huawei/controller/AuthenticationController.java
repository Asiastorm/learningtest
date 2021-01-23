package com.huawei.controller;

import com.huawei.Dao.UserInfoDo;
import com.huawei.req.LoginReq;
import com.huawei.rsp.BaseRsp;
import com.huawei.rsp.LoginRsp;
import com.huawei.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseRsp<LoginRsp> login(@RequestBody @Valid LoginReq loginReq) {
        UserInfoDo userInfoDo = new UserInfoDo();
        BeanUtils.copyProperties(loginReq,userInfoDo);
        return authenticationService.login(userInfoDo);
    }
}
