package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName:Sort
 * @Author:lxx
 * @Date 2022/7/24 16:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sort {
    String t_id;
    String l_id;
    String subject;

    public Sort(Object t_id, Object l_id) {
        this.l_id= (String) l_id;
        this.t_id = (String) t_id;
    }
}
