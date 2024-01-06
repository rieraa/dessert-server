package com.example.desserts.model.dto;
import com.example.desserts.model.entity.Dessert;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 */
@Data
public class DessertListDTO implements Serializable {

    /**
     * 甜品列表
     */
    private List<Dessert> desserts;

    /**
     * 是否还有更多数据
     */
    private boolean hasMoreData;
}