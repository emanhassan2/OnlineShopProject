package edu.miu.cs425.onlineshoppingapp.service;

import edu.miu.cs425.onlineshoppingapp.model.CartItem;

public interface ShoppingCartService {
    public CartItem addProductToShoppingCart(CartItem cartItem);
}
