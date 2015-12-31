package com.service.impl;

import com.dao.OrderDAO;
import com.model.Order;
import com.service.OrderService;

/**
 * Created by stiles on 15/12/30.
 */
public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public OrderServiceImpl() {
        System.out.println("OrderServiceImpl is created.");
    }

    @Override
    public boolean update(Order order) {
        return orderDAO.update(order);
    }

    @Override
    public boolean add(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public boolean remove(String id) {
        return orderDAO.delete(id);
    }

    @Override
    public Order findOneById(String id) {
        return orderDAO.findById(id);
    }

    @Override
    public boolean ifConflict(Order order) {
        return orderDAO.ifConflict(order);
    }
}