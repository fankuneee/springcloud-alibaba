package com.huzhenghui.service.impl;

import com.huzhenghui.dao.OrderDao;
import com.huzhenghui.domain.Order;
import com.huzhenghui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

}
