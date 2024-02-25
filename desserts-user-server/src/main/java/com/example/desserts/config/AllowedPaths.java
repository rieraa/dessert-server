package com.example.desserts.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllowedPaths {

    public static final Set<String> ALLOWED_PATHS = new HashSet<>(Arrays.asList(
            "/user/login",
            "/user/register",
            "/dessert/getAllDessert",
            "/dessert/getDessertById",
            "/file/upload"
    ));

}
