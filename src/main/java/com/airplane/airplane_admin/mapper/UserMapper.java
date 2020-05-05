package com.airplane.airplane_admin.mapper;

import com.airplane.airplane_admin.entity.Flight;
import com.airplane.airplane_admin.entity.Order;
import com.airplane.airplane_admin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from users where userName=#{username} and passWord=#{password}")//判断登录的用户名和密码是否正确
    List<User> findUser(@Param("username") String username,@Param("password") String password);

    @Select("select * from flights where flightNumber=#{flightNumber}")//判断登录的用户名和密码是否正确
    List<User> existFlight(@Param("flightNumber") String flightNumber);

    @Select("select * from adminuser where userName=#{username} and passWord=#{password}")//判断管理员登录的用户名和密码是否正确
    List<User> findAdminUser(@Param("username") String username,@Param("password") String password);

    @Select("select * from users where userName=#{username}")//判断用户名是否存在
    List<User> existUsername(@Param("username") String username);

    @Insert("insert into users values(#{username},#{password})")//注册成功插入表中
    void addUser(@Param("username") String username,@Param("password") String password);

    @Select("select * from flights where flightNumber=#{flightNumber} and seat!=0") //选择有座位的航班
    List<Flight> findFlight_Haveseat(@Param("flightNumber") String flightNumber);

    @Select("select * from flights where origin=#{origin} and destination=#{destination} and date=#{date} and seat!=0") //选择符合条件的航班
    List<Flight> findFlight(@Param("origin") String origin,@Param("destination") String destination,@Param("date") String date);

    @Select("select * from orders where id=#{id} and flightNumber=#{flightNumber}") //判断用户是否已经选择乘坐的这一航班，同一航班不能预订多次
    List<Order> existOrder(@Param("id") String id, @Param("flightNumber") String flightNumber);

    @Update("update flights set seat=seat-1 where flightNumber=#{flightNumber}")//预订成功航班飞机座位减一
    void updateFlight_subtract(@Param("flightNumber") String flightNumber);

    @Insert("insert into orders(flightNumber,id,name,sex,tel,username) values(#{flightNumber},#{id},#{name},#{sex},#{tel},#{username})")//预订机票成功更新订单信息
    void addOrder(@Param("flightNumber") String flightNumber,@Param("id") String id,@Param("name") String name,
                  @Param("sex") String sex,@Param("tel") String tel,@Param("username") String username);

    @Delete("delete from orders where flightNumber=#{flightNumber} and id=#{id}")//退票删除订单信息或者删除过期订单
    void deleteOrder(@Param("id") String id,@Param("flightNumber") String flightNumber);

    @Update("update flights set seat=seat+1 where flightNumber=#{flightNumber}")//退票成功航班飞机座位加一
    void updateFlight_add(@Param("flightNumber") String flightNumber);

    @Select("select * from orders,flights where username=#{username} and orders.flightNumber=flights.flightNumber") //订票列表
    List<Map> findOrder(@Param("username") String username);

    @Insert("insert into flights values(#{flightNumber},#{startTime},#{endTime},#{cost},#{origin},#{destination},#{moudel},#{seat},#{date})")//预订机票成功更新订单信息
    void addFlight(@Param("flightNumber") String flightNumber,@Param("startTime") String startTime,@Param("endTime") String endTime,
                  @Param("cost") String cost,@Param("origin") String origin,@Param("destination") String destination,@Param("moudel") String moudel,
                   @Param("seat") int seat,@Param("date") String date);

    @Delete("delete from users where username=#{username}")//删除用户
    void deleteUser(@Param("username") String username);

    @Select("select * from orders,flights where orders.flightNumber=flights.flightNumber")
    List<Map> orders();


    @Delete("delete from flights where flightNumber=#{flightNumber}")
    void deleteFlight(@Param("flightNumber") String flightNumber);

    @Select("select * from flights")
    List<Flight> flights();

    @Select("select * from users")
    List<User> users();

    @Update("update adminuser set password=#{password}")
    void changePwd(@Param("password") String password);
}
