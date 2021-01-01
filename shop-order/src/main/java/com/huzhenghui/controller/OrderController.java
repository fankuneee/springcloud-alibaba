package com.huzhenghui.controller;

import com.alibaba.fastjson.JSON;
import com.huzhenghui.domain.Order;
import com.huzhenghui.domain.Product;
import com.huzhenghui.service.OrderService;
import com.huzhenghui.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        Product product = this.productService.findByPid(pid);
        log.info(">>商品信息，查询结果:" + JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }


    //准备买1件商品
//    @GetMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
//        String url = "service-product";
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        //通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject("http://" + url +
//                "/product/" + pid, Product.class);
//        log.info(">>商品信息，查询结果:" + JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(product.getPid());
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.save(order);
//        return order;
//    }


    //准备买1件商品
//    @GetMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
//        //从nacos中获取服务地址
//        ServiceInstance serviceInstance =
//                discoveryClient.getInstances("service-product").get(0);
//        String url = serviceInstance.getHost() + ":" +
//                serviceInstance.getPort();
//        log.info(">>从nacos中获取到的微服务地址为:" + url);
//        //通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject(
//                "http://" + url + "/product/" + pid, Product.class);
//        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(product.getPid());
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.save(order);
//        return order;
//    }


    //准备买1件商品
//    @GetMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
//        //通过restTemplate调用商品微服务
//        Product product = restTemplate.getForObject(
//                "http://localhost:8081/product/" + pid, Product.class);
//        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(product.getPid());
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.save(order);
//        return order;
//    }
}
