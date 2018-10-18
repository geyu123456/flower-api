package com.flower.User.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "user")
public class User  {
    private  String id;
    private  String username;
    private  String account;
    private  String password;
    private  boolean enabled;
    private List<String> roles;

}
