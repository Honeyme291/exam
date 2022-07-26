package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName:User
 * @Author:lxx
 * @Date 2022/7/23 19:20
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
//t_id；打分老师id。
//l_id；被停课老师id。
//subject 被听得科目。
public class User {
    private String t_id;
    private String l_id;
    private String subject;
    private Date ctime;
}
