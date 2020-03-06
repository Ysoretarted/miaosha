package com.zju.ysoretarded.dao;

import com.zju.ysoretarded.domain.MiaoshaOrder;
import com.zju.ysoretarded.domain.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author zcz
 * @CreateTime 2020/3/6 20:37
 */

@Mapper
@Component
public interface OrderDao {


    @Select("select * from miaosha_order where user_id = #{userId} and goods_id = #{goodsId} ")
    MiaoshaOrder getMiaoshaOrderByUserIdAndGoodsId(@Param("userId") Long userId,@Param("goodsId") Long goodsId);

    /*@Insert("insert into order_info(user_id,goods_id,goods_name,goods_count,goods_price,order_channel,status,create_date)values(" +
            "#{userId},#{goodsId},#{goodsName},#{goodsCount},#{goodsPrice},#{orderChannel},#{status},#{createDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = long.class, before = false, statement = "select last_insert_id()")
    long insert(OrderInfo orderInfo);*/

    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey( keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public long insert(OrderInfo orderInfo);


    @Insert("insert into miaosha_order (user_id, goods_id, order_id) values(#{userId}, #{goodsId},#{orderId})")
    void insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
