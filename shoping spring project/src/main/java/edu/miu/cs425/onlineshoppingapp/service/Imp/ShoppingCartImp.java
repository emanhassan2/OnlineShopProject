package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.model.CartItem;
import edu.miu.cs425.onlineshoppingapp.repository.ShoppingCartRepository;
import edu.miu.cs425.onlineshoppingapp.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartImp implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public CartItem addProductToShoppingCart(CartItem cartItem) {
//        List<CartItem> cartItems = shoppingCartRepository.g
//        return shoppingCartRepository.s;
        return null;
    }
}
