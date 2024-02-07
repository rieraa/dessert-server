package com.example.desserts.domain.DTO;

import com.example.desserts.model.entity.Dessert;
import lombok.Data;

@Data
public class AddDessertDTO extends Dessert  {
    private String tasteName;

    private String speName;

    private String extra;
}
