package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName:Classes
 * @Author:lxx
 * @Date 2022/7/23 19:21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private String T_id;
    private String L_id;
    private String area;
    private int indexs;
    private String selectsongdong;
    private Date ctime;
    private int score;
    private String firstSubject;
    private String secondSubject;
    private Integer valued;
}
