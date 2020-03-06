package com.zju.ysoretarded.service;

import com.zju.ysoretarded.dao.MiaoshaDao;
import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.domain.OrderInfo;
import com.zju.ysoretarded.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zcz
 * @CreateTime 2020/3/6 21:20
 */

@Service
public class MiaoshaService {

    @Autowired
    MiaoshaDao miaoshaDao;

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存 下订单  写入秒杀订单 表
        goodsService.reduceStock(goods);

        // order_info  miaosha_order
        return orderService.createOrder(user,goods);

    }
}
