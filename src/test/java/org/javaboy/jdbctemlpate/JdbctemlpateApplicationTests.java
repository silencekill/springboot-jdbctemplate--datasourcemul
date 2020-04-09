package org.javaboy.jdbctemlpate;


import org.javaboy.jdbctemlpate.entity.Student;
import org.javaboy.jdbctemlpate.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JdbctemlpateApplicationTests {

    @Autowired
    StudentService studentService;
    @Test
    void contextLoads() {
        studentService.add();
    }

    @Test
    void update() {
        studentService.update();
    }

    @Test
    void delete() {
        studentService.delete();
    }

    @Test
    void findAll(){
        List<Student> students = studentService.listAll();
        System.out.println(students);
    }

    @Test
    void listAll2(){
        List<Student> students = studentService.listAll();
        System.out.println(students);
    }

    @Resource(name = "jdbcTemplate1")
    JdbcTemplate jdbcTemplate1;
    @Resource(name = "jdbcTemplate2")
    JdbcTemplate jdbcTemplate2;

    @Test
    void  dataSourceMul(){
        List<Student> list1 = jdbcTemplate1.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
        List<Student> list2 = jdbcTemplate2.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(list1);
        System.out.println(list2);
    }


}
