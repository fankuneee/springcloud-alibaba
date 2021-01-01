package com.huzhenghui.service.impl;

import com.huzhenghui.dao.ProductDao;
import com.huzhenghui.domain.Product;
import com.huzhenghui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }


}
