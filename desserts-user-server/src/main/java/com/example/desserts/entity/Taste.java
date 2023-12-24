package com.example.desserts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
public class Taste implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "taste_id", type = IdType.AUTO)
    private Integer tasteId;

    private String tasteName;

    private Integer dessertId;

    public Integer getTasteId() {
        return tasteId;
    }

    public void setTasteId(Integer tasteId) {
        this.tasteId = tasteId;
    }

    public String getTasteName() {
        return tasteName;
    }

    public void setTasteName(String tasteName) {
        this.tasteName = tasteName;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    @Override
    public String toString() {
        return "Taste{" +
        "tasteId = " + tasteId +
        ", tasteName = " + tasteName +
        ", dessertId = " + dessertId +
        "}";
    }
}
