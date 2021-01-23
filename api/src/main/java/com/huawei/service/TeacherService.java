package com.huawei.service;

import com.huawei.Dao.TeacherDao;
import com.huawei.Dao.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;
    public List<Teacher> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }
    public Teacher getTeacherById(Long id){
        return teacherDao.getTeacherById(id);
    }
    public void insertTeacher(Teacher teacher){
        teacher.setCreateTime(System.currentTimeMillis());
        teacher.setUpdateTime(System.currentTimeMillis());
        teacherDao.insertTeacher(teacher);
    }
    public void updateTeacher(Teacher teacher, Long id){
        teacher.setUpdateTime(System.currentTimeMillis());
        teacherDao.updateTeacher(teacher,id);
    }
    public void deleteTeacher(Long id) {
        teacherDao.deleteTeacher(id);
    }
}
