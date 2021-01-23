package com.huawei.controller;

import com.huawei.service.TeacherService;
import com.huawei.Dao.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class.getName());

    @Autowired
    TeacherService teacherService;


    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAllTeacher();
    }


    @PostMapping
    public void insertTeacher(@RequestBody Teacher teacher) {
        teacher.setCreateTime(System.currentTimeMillis());
        teacher.setUpdateTime(System.currentTimeMillis());
        teacherService.insertTeacher(teacher);
    }


    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }


    @PutMapping("{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody Teacher Teacher) {
        teacherService.updateTeacher(Teacher, id);
        return;
    }


    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return;
    }

}