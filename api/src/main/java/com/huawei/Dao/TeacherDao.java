package com.huawei.Dao;

import com.huawei.Dao.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface TeacherDao {
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long id);
    void insertTeacher(Teacher teacher);
    void updateTeacher(@Param("teacher")Teacher teacher, @Param("id") Long id);
    void deleteTeacher(@Param("id") Long id);
}
