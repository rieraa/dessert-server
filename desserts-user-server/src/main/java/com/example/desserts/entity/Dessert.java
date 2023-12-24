package com.example.desserts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 */
public class Dessert implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dessert_id", type = IdType.AUTO)
    private Integer dessertId;

    private String dessertName;

    private String dessertExplain;

    /**
     * 封面图
     */
    private String dessertImg;

    private BigDecimal dessertPrice;

    /**
     * 详细图片(长图)
     */
    private String detailImg;

    /**
     * 保质期
     */
    private String shelfLife;

    /**
     * 存储方式
     */
    private String storageMethod;

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public String getDessertExplain() {
        return dessertExplain;
    }

    public void setDessertExplain(String dessertExplain) {
        this.dessertExplain = dessertExplain;
    }

    public String getDessertImg() {
        return dessertImg;
    }

    public void setDessertImg(String dessertImg) {
        this.dessertImg = dessertImg;
    }

    public BigDecimal getDessertPrice() {
        return dessertPrice;
    }

    public void setDessertPrice(BigDecimal dessertPrice) {
        this.dessertPrice = dessertPrice;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    @Override
    public String toString() {
        return "Dessert{" +
        "dessertId = " + dessertId +
        ", dessertName = " + dessertName +
        ", dessertExplain = " + dessertExplain +
        ", dessertImg = " + dessertImg +
        ", dessertPrice = " + dessertPrice +
        ", detailImg = " + detailImg +
        ", shelfLife = " + shelfLife +
        ", storageMethod = " + storageMethod +
        "}";
    }
}
