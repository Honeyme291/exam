package com.example.exam.service;

import com.example.exam.entity.Classes;
import com.example.exam.entity.Sort;
import com.example.exam.entity.Subject;
import com.example.exam.entity.User;
import com.example.exam.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Author:lxx
 * @Date 2022/7/23 20:38
 **/
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    @Override
    public int insertByName(User user) {
        return userMapper.insertByName(user);
    }

    @Override
    public List<User> selectUserByName(User user) {
        return userMapper.selectUserByName(user);
    }

    @Override
    public List<String> selectTeacher(String t_name) {
       return userMapper.selectTeacher(t_name);
    }

    @Override
    public List<String> selectListened(String l_name) {
        return userMapper.selectListened(l_name);

    }

    @Override
    public void updateTime(User user) {
         userMapper.updateTime(user);
    }

    @Override
    public List<Subject> selectFirst(String subject) {
        return  userMapper.selectFirst(subject);
    }

    @Override
    public int insertClasses(Classes classes) {
        return userMapper.insertClasses(classes);
    }

    @Override
    public List<Classes> selectClasses(Sort sort) {
        return userMapper.selectClasses(sort);
    }

    @Override
    public int updateClasses(Classes classes) {
        return userMapper.updateClasses(classes);
    }

    @Override
    public Subject selectString(Classes classes) {
        return userMapper.selectString(classes);
    }

    @Override
    public int updateClassesAll(Classes classes) {
        return userMapper.updateClassesAll(classes);
    }

    @Override
    public Classes selectClassesAll(Classes classes) {
        return userMapper.selectClassesAll(classes);
    }

    @Override
    public List<Subject> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<Integer> selectClassesData(Sort sort) {
        return userMapper.selectClassesData(sort);
    }
}
