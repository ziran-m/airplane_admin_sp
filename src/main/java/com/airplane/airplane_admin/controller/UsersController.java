package com.airplane.airplane_admin.controller;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;
import com.airplane.airplane_admin.service.UserServiceImpl;
import com.airplane.airplane_admin.token.JwtUtil;
import com.airplane.airplane_admin.token.PassToken;
import com.airplane.airplane_admin.token.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UsersController {
    @Autowired
    private UserServiceImpl userService;

    @PassToken
    @PostMapping("login")
    public String userLogin(@RequestBody User user){
        String mytoken = "";
        if(userService.doLogin(user)){
            mytoken = JwtUtil.createToken(user);
        }
        return mytoken;
    }

    @PassToken
    @PostMapping("register")
    public String userRegister(@RequestBody User user){
        String token = "";
        if(!userService.doExist(user)){
            if(userService.doRegister(user)){
                token = JwtUtil.createToken(user);
            }
        }
        return token;
    }

    @PassToken
    @PostMapping("search")
    public List<Flight> resultSearch(@RequestBody Flight flight){
        return userService.doSearchFlight(flight);
    }

    @UserLoginToken
    @PostMapping("reserve")
    public boolean resultReserve(@RequestBody Order order){
        return userService.doReserve(order);
    }

    @UserLoginToken
    @PostMapping("delete")
    public boolean resultDelete(@RequestBody Order order){
        return userService.doDelete(order);
    }

    @UserLoginToken
    @PostMapping("order")
    public List<Map> resultOrder(HttpServletRequest request){
        return userService.doSearchOrder();
    }


}
