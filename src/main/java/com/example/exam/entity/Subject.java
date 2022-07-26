package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName:Subject
 * @Author:lxx
 * @Date 2022/7/23 19:20
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {
    private String f_name;
    private String s_name;
    private String th_name;
    private int value;
}
