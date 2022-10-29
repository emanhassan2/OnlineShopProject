package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.model.CartItem;
import edu.miu.cs425.onlineshoppingapp.model.ShoppingCart;
import edu.miu.cs425.onlineshoppingapp.model.User;
import edu.miu.cs425.onlineshoppingapp.repository.UserRepository;
import edu.miu.cs425.onlineshoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CartItem addCartItemToUseShoppingCart(User user, CartItem cartItem) {
        Optional<User> user1 =  userRepository.findById(user.getUserId());
        ShoppingCart shoppingCart = user1.get().getShoppingCart();
       List<CartItem> cartItems = shoppingCart.getCartItem();
        if(!cartItems.contains(cartItem)) {
            cartItems.add(cartItem);
            shoppingCart.setCartItem(cartItems);
        }
        else {

            for(int i = 0; i < cartItems.size(); i++) {
                if(cartItems.get(i) == cartItem) {
                    CartItem c = cartItems.get(i);
                    c.setQuantity(c.getQuantity()+1);
                }
            }
        }
        return cartItem;
    }
}
