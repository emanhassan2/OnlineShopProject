package edu.miu.cs425.onlineshoppingapp.dtos;

import edu.miu.cs425.onlineshoppingapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String jwt;
    private User user;
}
