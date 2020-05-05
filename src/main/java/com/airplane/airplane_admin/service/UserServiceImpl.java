package com.airplane.airplane_admin.service;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;
import com.airplane.airplane_admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("User_Service")
public class UserServiceImpl implements User_Service {

    private User user;//用于token验证

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean doExist(User user) {
        List<User> result = userMapper.existUsername(user.getUsername());
        if(result.size() == 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean doLogin( User user) {
        //连接数据库
        List<User> result = userMapper.findUser(user.getUsername(),user.getPassWord());
        if(result.size() != 0){
            this.user = user;
            return true;
        }
        return false;
    }

    @Override
    public boolean doRegister(User user) {
        userMapper.addUser(user.getUsername(),user.getPassWord());
        this.user = user;
        return true;
    }

    @Override
    public List<Flight> doSearchFlight(Flight flight) {
        return userMapper.findFlight(flight.getOrigin(),flight.getDestination(),flight.getDate());
    }

    @Override
    public boolean doReserve(Order order) {
        List<Order> result = userMapper.existOrder(order.getId(), order.getFlightNumber());
        List<Flight> _result = userMapper.findFlight_Haveseat(order.getFlightNumber());
        if(result.size() == 0 && _result.size() != 0){
            order.setUsername(user.getUsername());
            userMapper.addOrder(order.getFlightNumber(), order.getId(), order.getName(), order.getSex(), order.getTel(),order.getUsername());
            userMapper.updateFlight_subtract(order.getFlightNumber());
            return true;
        }
        return false;
    }

    @Override
    public boolean doDelete(Order order) {
        userMapper.deleteOrder(order.getId(), order.getFlightNumber());
        userMapper.updateFlight_add(order.getFlightNumber());
        return true;
    }

    @Override
    public List<Map> doSearchOrder() {
        List<Map> result = userMapper.findOrder(user.getUsername());
        return result;
    }

    public User getUser() {
        return user;
    }
}
