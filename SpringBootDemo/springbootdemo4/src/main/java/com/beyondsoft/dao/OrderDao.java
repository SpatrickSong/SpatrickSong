package com.beyondsoft.dao;

import com.beyondsoft.pojo.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findById(String id);
    String addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(String id);
}
