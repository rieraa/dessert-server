package com.example.desserts.domain.DTO;


import com.example.desserts.model.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserListDTO {
    List<User> userList;
    private int total;

}
