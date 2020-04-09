package org.javaboy.jdbctemlpate.service;

import org.javaboy.jdbctemlpate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    @Qualifier("jdbcTemplate1")
    JdbcTemplate jdbcTemplate1;

    @Resource(name = "jdbcTemplate2")
    JdbcTemplate jdbcTemplate2;

    /**
     * 添加数据
     * @return
     */
    public Integer add(){
        return jdbcTemplate1.update("insert into student (name ,age) values (?,?)","lisi", 19);
    }

    /**
     * 修改数据
     * @return
     */
    public Integer update(){
        return jdbcTemplate1.update("update student set name=? where id = ?","zhangsansan", 1);
    }

    /**
     * 修改数据
     * @return
     */
    public Integer delete(){
        return jdbcTemplate1.update("delete from student where id = ?", 1);
    }

    /**
     * 查询数据
     * 当数据库表字段与实体类字段不一致时,使用RowMapper<>
     * @return
     */
    public List<Student> listAll(){
        return jdbcTemplate1.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student student = new Student(id,name,age);
                return student;
            }
        });
    }

    /**
     * 查询所有的数据
     * 当数据库字段与实体类字段一致的话,查询参数 new BeanPropertyRowMapper<Student>()
     * @return
     */
    public List<Student> listAll2(){
        return jdbcTemplate1.query("select * from student", new BeanPropertyRowMapper<Student>());
    }

    public void listAllDataSourceMul(){
        List<Student> list1 = jdbcTemplate1.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
        List<Student> list2 = jdbcTemplate2.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
        System.out.println(list1);
        System.out.println(list2);
    }

}
