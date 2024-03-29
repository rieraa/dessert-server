package com.example.desserts.model.vo;
import com.example.desserts.model.entity.Dessert;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 */
@Data
public class DessertListVO implements Serializable {

    /**
     * 甜品列表
     */
    private List<Dessert> desserts;


    /**
     * 甜品总数
     */
    private long total;

    /**
     * 是否还有更多数据
     */
    private boolean hasMoreData;
}