package edu.miu.cs425.onlineshoppingapp.service;

import edu.miu.cs425.onlineshoppingapp.dtos.CartItemDto;
import edu.miu.cs425.onlineshoppingapp.model.CartItem;
import edu.miu.cs425.onlineshoppingapp.model.ShoppingCart;
import edu.miu.cs425.onlineshoppingapp.model.User;

public interface UserService {
    public ShoppingCart creatShoppingCart(User user, Integer cartItemId);
    public CartItem addCartItemToUseShoppingCart( CartItemDto cartItem);
    public ShoppingCart getUserShoppingCart();
    public void creatOrder();
}
