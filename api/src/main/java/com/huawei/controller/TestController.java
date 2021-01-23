package com.huawei.controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.huawei.Dao.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {
    private static LoadingCache cache = CacheBuilder
            .newBuilder()
            .expireAfterAccess(10, TimeUnit.SECONDS)
            .build(new CacheLoader<String, User>() {
                @Override
                public User load(String s) throws Exception {
                    User user = User.builder()
                            .userName(s)
                            .email("Email")
                            .createTime(System.currentTimeMillis())
                            .build();
                    System.out.println("Create new User!");
                    return user;
                }
            });

    @Value("${test}")
    private String test;

    @RequestMapping(value = "/1", method = RequestMethod.POST)
    private String test() {
        return test;
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST)
    private Object test2() throws ExecutionException {

        return cache.get("lisi");

    }
}
