package com.example.databasepj.controller.user;

import com.example.databasepj.service.UserService;
import com.example.databasepj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "api/login")
    @ResponseBody
    //登录界面
    public String login(@RequestBody User requestUser) throws SQLException {

        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        //做两步判断（用户名和密码）
        User user = userService.getByName(username);
        if(user==null){return "fuck";}
        else{
            return "existed";
        }
//        if (null == user) {
//            return new Result(400,"wrong password");
//        }else if(user.getRole().equals("admin")){
//            User admin=userService.getByName(username);
//            return new Result(200,"admin",admin.getidnumber(),admin.getId());
//        } else if (user.getRole().equals("shopper")) {
//            User merchant=userService.getByName(username);
//            return new Result(200,"shopper",merchant.getidnumber(),merchant.getId());
//        }else {
//            User user123=userService.getByName(username);
//            return new Result(200,"user",user123.getidnumber(), user123.getId());
//        }
    }
}
