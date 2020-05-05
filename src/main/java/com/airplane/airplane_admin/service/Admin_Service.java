package com.airplane.airplane_admin.service;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;

import java.util.List;
import java.util.Map;

public interface Admin_Service {

    boolean doLogin(User user);

    boolean addFlight(Flight flight);

    List<Flight> resultFlight();

    List<Map> resultOrder();

    List<User> resultUser();

    boolean deleteFlight(String flightNumber);

    boolean deleteUser(String username);

    boolean deleteOrder(Order order);

    boolean changePwd(String password);
}
