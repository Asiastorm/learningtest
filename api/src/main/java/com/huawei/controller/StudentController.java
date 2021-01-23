package com.huawei.controller;

import com.google.common.base.Preconditions;
import com.huawei.Dao.model.Student;
import com.huawei.req.StudentReq;
import com.huawei.rsp.BaseRsp;
import com.huawei.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final static Logger logger = LoggerFactory.getLogger(KlassController.class.getName());

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public BaseRsp<List<Student>> getAllStudent(){
        BaseRsp<List<Student>> rsp = new BaseRsp<List<Student>>(studentService.getAllStudent("DESC"));
        return rsp;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseRsp<String> addStudent(@RequestBody StudentReq studentreq){
        Preconditions.checkNotNull(studentreq,"StudentReq is null!");
        Preconditions.checkNotNull(studentreq.getKlass(),"StudentReq is null!");
        Student student = new Student();
        BeanUtils.copyProperties(studentreq,student);
        student.setKlassId(studentreq.getKlass().getId());
        List<Student> students = studentService.getStudentBySno(student.getStudentId());
        if(!students.isEmpty()) {
            return new BaseRsp<String>("错误","101");
        }
        studentService.addStudent(student);
        return null;
    }
}
