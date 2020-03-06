package com.zju.ysoretarded.service;

import com.zju.ysoretarded.dao.OrderDao;
import com.zju.ysoretarded.domain.MiaoshaOrder;
import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.domain.OrderInfo;
import com.zju.ysoretarded.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zcz
 * @CreateTime 2020/3/6 20:36
 */

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public MiaoshaOrder getMiaoshaOrderByUserIdAndGoodsId(Long userId, Long goodsId) {
        return orderDao.getMiaoshaOrderByUserIdAndGoodsId(userId,goodsId);
    }

    @Transactional
    public OrderInfo createOrder(MiaoshaUser user, GoodsVo goods) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsCount(1);
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setUserId(user.getId());
        orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderInfo.setOrderChannel(0);
        orderInfo.setStatus(0);
        long orderId = orderDao.insert(orderInfo);

        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setUserId(user.getId());
        orderDao.insertMiaoshaOrder(miaoshaOrder);
        return orderInfo;

    }
}
