package com.airplane.airplane_admin.controller;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;
import com.airplane.airplane_admin.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("login")
    public List<Flight> adminLogin(@RequestBody User user){
        if(adminService.doLogin(user)){
            return adminService.resultFlight();
        }
        return null;
    }

    @PostMapping("add")
    public boolean addFlight(@RequestBody Flight flight){
        return adminService.addFlight(flight);
    }

    @PostMapping("showflight")
    public List<Flight> showFlight(){
        return adminService.resultFlight();
    }

    @PostMapping("showorder")
    public List<Map> showOrder(){
        return adminService.resultOrder();
    }

    @PostMapping("showuser")
    public List<User> showUser(){
        return adminService.resultUser();
    }

    @PostMapping("deleteflight")
    public boolean deleteFlight(@RequestBody Flight flight){
        return adminService.deleteFlight(flight.getFlightNumber());
    }

    @PostMapping("deleteorder")
    public boolean deleteOrder(@RequestBody Order order){
        return adminService.deleteOrder(order);
    }

    @PostMapping("deleteuser")
    public boolean deleteUser(@RequestBody User user){
        return adminService.deleteUser(user.getUsername());
    }

    @PostMapping("setting")
    public boolean setting(@RequestBody User user){
        return adminService.changePwd(user.getPassWord());
    }
}
