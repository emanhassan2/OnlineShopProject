package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.model.ShoppingCart;
import edu.miu.cs425.onlineshoppingapp.model.User;
import edu.miu.cs425.onlineshoppingapp.repository.UserRepository;
import edu.miu.cs425.onlineshoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ShoppingCart creatShoppingCart(User user, Integer CartItemId) {
        LocalDate date = LocalDate.now();
//        ShoppingCart shoppingCart = ShoppingCart.builder()
//                .createdDate(date)
//                .user(user)
//                .
//                .build();
        return null;
    }
}
