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
public class Specification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "spe_id", type = IdType.AUTO)
    private Integer speId;

    /**
     * 规格
     */
    private String speName;

    private Integer dessertId;

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public String getSpeName() {
        return speName;
    }

    public void setSpeName(String speName) {
        this.speName = speName;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    @Override
    public String toString() {
        return "Specification{" +
        "speId = " + speId +
        ", speName = " + speName +
        ", dessertId = " + dessertId +
        "}";
    }
}
