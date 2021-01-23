package com.huawei.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserinfoDao {
    List<UserInfoDo> queryUserinfo(@Param("pojo") UserInfoDo condition);
}
