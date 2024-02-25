package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 购物车相关服务
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    /**
     * 根据用户ID查询购物车商品列表
     * @param userId 用户ID
     * @return 购物车商品列表
     */
    @Select("SELECT c.user_id, c.cart_id,c.quantity, d.dessert_id, d.dessert_name,d.dessert_img, c.unit_price,s.spe_id, s.spe_name,t.taste_id, t.taste_name " +
            "FROM cart c " +
            "JOIN dessert d ON c.dessert_id = d.dessert_id " +
            "LEFT JOIN specification s ON c.spe_id = s.spe_id " +
            "LEFT JOIN taste t ON c.taste_id = t.taste_id " +
            "WHERE c.user_id = #{userId}")
    List<CartListVO> selectCartGoodsByUserId(Integer userId);








}
