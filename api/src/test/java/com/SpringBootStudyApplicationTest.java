package com;

import com.huawei.Dao.UserInfoDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStudyApplication.class)
public class SpringBootStudyApplicationTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void getRedis(){
        redisTemplate.opsForValue().set("java","我爱java");
        String str =(String) redisTemplate.opsForValue().get("java");
    }
}
