package com.beyondsoft.dao.impl;

import com.beyondsoft.dao.OrderDao;
import com.beyondsoft.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

@Pepository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from t_order";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,new Object[] list);
        while (rows.next()){
            Order order = new Order();
            list.add(order);
            order.id = rows.getString("order_id");
            order.no = rows.getString("order_no");
            order.date = rows.getDate("order_date");
            order.quantity = rows.getInt("quantity");
        }
        return list;
    }

    @Override
    public Order findById(String id) {
        return null;
    }

    @Override
    public String addOrder(Order order) {
        return null;
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(String id) {

    }
}
