package edu.miu.cs425.onlineshoppingapp.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cart_items")
@EqualsAndHashCode
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    private Integer quantity;

    @OneToOne
    @JoinColumn
    private Product product;

    @ManyToOne
    @JoinColumn
    private ShoppingCart shoppingCart;
}
