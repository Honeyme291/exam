package com.example.exam.service;

import com.example.exam.entity.Classes;
import com.example.exam.entity.Sort;
import com.example.exam.entity.Subject;
import com.example.exam.entity.User;

import java.util.List;

/**
 * @ClassName:UserService
 * @Author:lxx
 * @Date 2022/7/23 20:37
 **/
public interface UserService {
    public int insertByName(User user);

    public List<User> selectUserByName(User user);//如果这个里面有，就把之前填入的数据展示给他，如果没有则插入数据

    public List<String> selectTeacher( String t_name);

    public List<String> selectListened( String l_name);

    public void updateTime(User user);

    List<Subject> selectFirst(String subject);

    public int insertClasses(Classes classes);

    public  List<Classes> selectClasses(Sort sort);

    int updateClasses(Classes classes);

    public Subject selectString(Classes classes);

    public int updateClassesAll(Classes classes);
    public Classes selectClassesAll(Classes classes);

    public List<Subject> selectAll();
    public  List<Integer> selectClassesData(Sort sort);

}
