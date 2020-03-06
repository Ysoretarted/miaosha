package com.zju.ysoretarded.dao;

import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.domain.OrderInfo;
import com.zju.ysoretarded.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zcz
 * @CreateTime 2020/3/6 21:21
 */

@Mapper
@Component
public interface MiaoshaDao {


    OrderInfo miaosha(MiaoshaUser user, GoodsVo goods);
}
