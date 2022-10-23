package edu.miu.cs425.onlineshoppingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @NotBlank(message = "name cannot be blank or empty or null")
    @Column(nullable = false)
    private String name;
    private String category;
    private Double price;
    private String description;

    @OneToMany(mappedBy = "product")

    private List<Image> images;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    List<Review> reviews;

    @OneToOne(mappedBy = "product")
    private CartItem cartItem;

    @OneToMany(mappedBy = "product")
    private List<OrderLineItem> orderLineItem;


}
