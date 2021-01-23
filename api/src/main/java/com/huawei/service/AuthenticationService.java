package com.huawei.service;

import com.huawei.Dao.UserinfoDao;
import com.huawei.Dao.UserInfoDo;
import com.huawei.rsp.BaseRsp;
import com.huawei.rsp.LoginRsp;
import com.huawei.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserinfoDao userinfoDao;

    @Autowired
    private RedisService redisService;

    public BaseRsp<LoginRsp> login(UserInfoDo condition) {
        List<UserInfoDo> userInfoDos = userinfoDao.queryUserinfo(condition);
        if (CollectionUtils.isEmpty(userInfoDos)) {
            return new BaseRsp<>(LoginRsp.builder().isValid(Boolean.FALSE).build());
        }
        String token = RandomUtils.getRandomUUID();
        redisService.set(token, condition);
        return new BaseRsp<>(LoginRsp.builder().isValid(Boolean.FALSE).token(token).build());
    }
}
