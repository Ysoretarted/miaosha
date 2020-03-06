package com.zju.ysoretarded.controller;

import com.zju.ysoretarded.domain.MiaoshaOrder;
import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.domain.OrderInfo;
import com.zju.ysoretarded.result.CodeMsg;
import com.zju.ysoretarded.service.GoodsService;
import com.zju.ysoretarded.service.MiaoshaService;
import com.zju.ysoretarded.service.OrderService;
import com.zju.ysoretarded.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zcz
 * @CreateTime 2020/3/6 20:24
 */

@RequestMapping("/miaosha")
@Controller
public class MiaoshaController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String toDetail(Model model,
                           MiaoshaUser user, @RequestParam("goodsId") long goodsId){
        model.addAttribute("user", user);
        if(null == user){
            return "login";
        }
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        // 判断库存   这里的话  多线程肯定是要出问题的
        if(stock <= 0){
            model.addAttribute("errormsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "miaosha_failed";
        }
        // 判断是否已经秒杀过来，防止一个人多次秒杀
        MiaoshaOrder miaoshaOrder = orderService.getMiaoshaOrderByUserIdAndGoodsId(user.getId(),goodsId);
        if(null != miaoshaOrder){
            model.addAttribute("errormsg",CodeMsg.REPEATED_MIAOSHA.getMsg());
            return "miaosha_failed";
        }

        //减库存 下订单  然后写入秒杀订单  这个得是一个事务操作
        OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goods);
        return "order_detail";
    }

}
