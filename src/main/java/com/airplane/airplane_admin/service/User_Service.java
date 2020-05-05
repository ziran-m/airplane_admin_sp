package com.airplane.airplane_admin.service;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;

import java.util.List;
import java.util.Map;

public interface User_Service {

    boolean doExist(User user);

    boolean doLogin(User user);

    boolean doRegister(User user);

    List<Flight> doSearchFlight(Flight flight);

    boolean doReserve(Order order);

    boolean doDelete(Order order);

    List<Map> doSearchOrder();
}
