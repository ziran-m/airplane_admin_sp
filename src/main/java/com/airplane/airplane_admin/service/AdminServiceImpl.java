package com.airplane.airplane_admin.service;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;
import com.airplane.airplane_admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("Admin_Servicce")
public class AdminServiceImpl implements Admin_Service {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean doLogin(User user) {
        List<User> result = userMapper.findAdminUser(user.getUsername(),user.getPassWord());
        if(result.size() != 0){
            return true;
        }
        return false;
    }



    @Override
    public boolean addFlight(Flight flight) {
        if(userMapper.existFlight(flight.getFlightNumber()).size() == 0) {
            userMapper.addFlight(flight.getFlightNumber(), flight.getStartTime(), flight.getEndTime(), flight.getCost(),
                    flight.getOrigin(), flight.getDestination(), flight.getMoudel(), flight.getSeat(), flight.getDate());
            return true;
        }
        return false;
    }

    @Override
    public List<Flight> resultFlight() {
        return userMapper.flights();
    }

    @Override
    public List<Map> resultOrder() {
        List<Map> result =  userMapper.orders();
        result.forEach(element->{
            element.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                    format(new Date(Long.valueOf(String.valueOf(element.get("time")))*1000)));
        });
        return result;
    }

    @Override
    public List<User> resultUser() {
        return userMapper.users();
    }

    @Override
    public boolean deleteFlight(String flightNumber) {
        userMapper.deleteFlight(flightNumber);
        return true;
    }

    @Override
    public boolean deleteUser(String username) {
        userMapper.deleteUser(username);
        return true;
    }

    @Override
    public boolean deleteOrder(Order order) {
        userMapper.deleteOrder(order.getId(),order.getFlightNumber());
        return true;
    }

    @Override
    public boolean changePwd(String password) {
        userMapper.changePwd(password);
        return true;
    }


}
