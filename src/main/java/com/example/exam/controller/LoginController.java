package com.example.exam.controller;

import com.example.exam.entity.Classes;
import com.example.exam.entity.Sort;
import com.example.exam.entity.Subject;
import com.example.exam.entity.User;
import com.example.exam.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName:LoginController
 * @Author:lxx
 * @Date 2022/7/9 15:52
 **/
@RestController
public class LoginController {
//    public String appId;
//    public String secret;
    @Resource
    UserService userService;
    /**
 * 登录
     * * @param subject
 * @return */
    @PostMapping("/doLogin")
    @ResponseBody
    public Map doLogin(@RequestBody Map<String, String> req){
    Map map = new HashMap();
    Date date =new Date();
    User user = new User(req.get("t_id"),req.get("l_id"),req.get("subject"),date);
    if (!req.isEmpty()) {
        List<User> op = userService.selectUserByName(user);
        if (op.size() > 1) {
            map.put("code", "404");
            map.put("result", "请找管理员联系");
        }
        if (op.isEmpty()) {
            if (userService.selectTeacher(req.get("t_id")).size() > 1) {
                map.put("code", "404");
                map.put("result", "请找管理员联系");
                return map;
            } else if (userService.selectListened(req.get("l_id")).size() > 1) {
                map.put("code", "404");
                map.put("result", "请找管理员联系");
                return map;
            } else if (userService.selectTeacher(req.get("t_id")).size() == 1 && userService.selectListened(req.get("l_id")).size() == 1) {
                userService.insertByName(user);
                map.put("code", 200);
                map.put("result", "登录成功");
                System.out.println("登录成功");
            } else {
                map.put("code", "404");
                map.put("result", "登录失败");
            }

        } else {
            userService.updateTime(user);
            map.put("code", 200);
            map.put("result", "登录成功");
        }
    }
    else{
            map.put("code", "404");
            map.put("result", "登录失败");
        }

    return map;
    }
/*
 * @Author Lxx
 * @Description //TODO
 * @Date 15:25 2022/7/23
 * @Param [java.lang.String]
 * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>

 **/
    @PostMapping("/doSort")
    @ResponseBody
    public  List<Map<String, Object>>  SortClass(@RequestBody Map<String, String> req) {
        List<Map<String, Object>> listMaps = new ArrayList<Map<String, Object>>();
        if (req.get("T_id") != "" && req.get("L_id") != "" && req.get("subject") != "") {
            String second_name="12";
            Sort sort =new Sort(req.get("T_id"),req.get("L_id"),req.get("subject"));
            List<Subject> list = userService.selectFirst(req.get("subject"));
            List<Classes> option =userService.selectClasses(sort);
            System.out.println(option);
            if(option.size()>0){
                for(int i=0;i<option.size();i++){
                    Map<String,Object> map =new HashMap<>();
                    if(!second_name.equals(option.get(i).getSecondSubject())){
                        second_name =option.get(i).getSecondSubject();
                        map.put("fatherNode",second_name);
                        i--;
                    }
                    else{
                        map.put("area",option.get(i).getArea());
                        map.put("indexs",option.get(i).getIndexs());
                    }
                    listMaps.add(map);
                }
            }
            else{
                for(int i=0;i<list.size();i++){
                    Map<String,Object> map =new HashMap<>();
                    if(!second_name.equals(list.get(i).getS_name())){
                        second_name = list.get(i).getS_name();
                        map.put("fatherNode",second_name);
                        i--;
                    }
                    else{
                        map.put("area",list.get(i).getTh_name());
                        map.put("indexs",0);
                    }
                    listMaps.add(map);
                }
            }
        }
        System.out.println(listMaps);
        return listMaps;
    }
    /*
     * @Author Lxx
     * @Description //TODO
     * @Date 17:25 2022/7/23
     * @Param [java.util.Map<java.lang.String,java.lang.Object>]
     * @return java.util.Map
     * 表单一个一个提交。
     **/
    @PostMapping("/doSubmit")
    @ResponseBody
    public Map doSubmit(@RequestBody  Map<String, Object> optionMaps){
        Map<String,Object> map =new HashMap<>();
        String p= (String) optionMaps.get("indexs");
        int k=(p.charAt(0)-'0');
        System.out.println(optionMaps.get("subject"));

        Classes classes =new Classes((String) optionMaps.get("T_id"), (String) optionMaps.get("L_id"), (String) optionMaps.get("area"), k, (String) optionMaps.get("selectsongdong"), new Date(), 6-k, (String) optionMaps.get("subject"), "0",0);
        Subject su = userService.selectString(classes);
        classes.setSecondSubject(su.getS_name());
        System.out.println(su.getValue());
        classes.setValued(su.getValue());
        if(userService.selectClassesAll(classes)!=null){
                //TODO
                //做一个更新操作。
                //怎么将flag变为一个可变变量。给classes不行。加一个实体类？？
            if( userService.updateClasses(classes)==0){
                map.put("result","网络原因，请重新再选择一次");
                map.put("code","601");
            }
        }
        else{
            if(userService.insertClasses(classes)==0){
                map.put("result","网络原因，请重新再选择一次");
                map.put("code","601");
            }
        }
        return map;
    }

    @GetMapping("/doDraw")
    @ResponseBody
    public List<Map<String,Object>> doDraw(){
        List<Map<String, Object>> mapList =new ArrayList<>();
        List<Subject> subjects = userService.selectAll();
        for(int i=0;i<subjects.size();i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name",subjects.get(i).getTh_name());
            map.put("max",6);
            mapList.add(map);
        }
        return mapList;
    }

    @PostMapping("/doData")
    @ResponseBody
    public List<Map<String,Object>> doData(@RequestBody  Map<String, Object> optionMaps){
        List<Map<String, Object>> mapList =new ArrayList<>();
        Sort sort = new Sort(optionMaps.get("T_id"),optionMaps.get("L_id"));
        List<Integer> list =  userService.selectClassesData(sort);
        Map<String,Object> map  =new HashMap<>();
        map.put("name","lxx");
        map.put("value",list);
        mapList.add(map);
        return mapList;
    }

}
