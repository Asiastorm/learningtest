package com.huawei.Dao;

import com.huawei.Dao.model.Klass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlassDao {
    int deleteByPrimaryKey(Long id);

    int insert(@Param(value = "pojo") Klass record);

    int insertSelective(Klass record);

    Klass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Klass record);

    int updateByPrimaryKey(@Param("id") Long id, @Param("pojo")Klass record);

    List<Klass> getAllKlass();

    List<Klass> getKlassByName(@Param(value = "name") String name);

    List<Klass> getKlassById(Long id);

}