package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 购物车相关服务
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    /**
     * 根据用户ID查询购物车商品列表
     * @param userId
     * @return
     */
    @Select("SELECT c.user_id, c.cart_id, d.dessert_id, d.dessert_name, d.dessert_price, s.spe_name AS specification_name " +
            "FROM cart c " +
            "JOIN dessert d ON c.dessert_id = d.dessert_id " +
            "LEFT JOIN specification s ON c.spe_id = s.spe_id " +
            "WHERE c.user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "cartId", column = "cart_id"),
            @Result(property = "dessertId", column = "dessert_id"),
            @Result(property = "dessertName", column = "dessert_name"),
            @Result(property = "dessertPrice", column = "dessert_price"),
            @Result(property = "specificationName", column = "specification_name")
    })
    List<CartListVo> selectCartGoodsByUserId(Integer userId);

}
