package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.dtos.CartItemDto;
import edu.miu.cs425.onlineshoppingapp.model.CartItem;
import edu.miu.cs425.onlineshoppingapp.model.Product;
import edu.miu.cs425.onlineshoppingapp.model.ShoppingCart;
import edu.miu.cs425.onlineshoppingapp.model.User;
import edu.miu.cs425.onlineshoppingapp.repository.CartItemRepository;
import edu.miu.cs425.onlineshoppingapp.repository.ShoppingCartRepository;
import edu.miu.cs425.onlineshoppingapp.repository.UserRepository;
import edu.miu.cs425.onlineshoppingapp.security.AwesomeUserDetails;
import edu.miu.cs425.onlineshoppingapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartItemRepository cartItemRepository;

//    private final User user = ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
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
    public CartItem addCartItemToUseShoppingCart(CartItemDto cartItem1) {
        CartItem cartItem = modelMapper.map(cartItem1, CartItem.class);
        if(cartItem != null){
            CartItem foundCartItem = cartItemRepository.findByProductProductId(cartItem.getProduct().getProductId());
            if(foundCartItem != null){
                int quantity = cartItem.getQuantity();
                cartItem = foundCartItem;
                cartItem.setQuantity(foundCartItem.getQuantity() + quantity);
            }
        }
         User user = ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();


        ShoppingCart shoppingCart = shoppingCartRepository.findByUserUserId(user.getUserId()).orElseThrow(() -> new RuntimeException("shopping cart 404"));

       List<CartItem> cartItems = shoppingCart.getCartItem();
        if(!cartItems.contains(cartItem)) {
            cartItems.add(cartItem);
            cartItem.setShoppingCart(shoppingCart);
            shoppingCart.setCartItem(cartItems);
        }
        else {

            for(int i = 0; i < cartItems.size(); i++) {
                if(cartItems.get(i).equals(cartItem)) {
                    CartItem c = cartItems.get(i);
                    c.setQuantity(c.getQuantity());
                }
            }
        }
        shoppingCartRepository.save(shoppingCart);
        return cartItem;
    }

    @Override
    public ShoppingCart getUserShoppingCart() {
        User user = ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

//        Optional<User> user1 = userRepository.findById(user.getUserId());
        ShoppingCart shoppingCart = user.getShoppingCart();
        return shoppingCart;
    }

    @Override
    public void creatOrder() {
        User user = ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

       Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findByUserUserId(user.getUserId());
       if(shoppingCart.isEmpty()) {
           throw new RuntimeException("user doesn't have shopping cart!");
       }

       List<CartItem> cartItems = shoppingCart.get().getCartItem();
       if(checkAvailabilityOfProduct(cartItems)) {
           throw new RuntimeException(" not enough product in the store!");
       }

        for(CartItem cartItem: cartItems) {
            Product product = cartItem.getProduct();
            product.setQuantityInStock(product.getQuantityInStock() - cartItem.getQuantity());
        }

        shoppingCartRepository.deleteById(shoppingCart.get().getShoppingCartId());

    }
    public boolean checkAvailabilityOfProduct(List<CartItem> cartItems) {
        for(CartItem cartItem: cartItems) {
            if(cartItem.getQuantity() > cartItem.getProduct().getQuantityInStock()) {
                return false;
            }
        }
        return true;
    }
}
