package com.example.desserts.domain.DTO;

import com.example.desserts.model.entity.Dessert;
import lombok.Data;

import java.util.List;

@Data
public class AddDessertDTO extends Dessert  {
    private List<String> tasteName;

    private List<String> speName;

    private String extra;
}
