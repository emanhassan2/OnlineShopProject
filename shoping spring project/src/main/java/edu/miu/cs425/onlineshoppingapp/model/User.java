package edu.miu.cs425.onlineshoppingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "First Name can not be blanc, empty string or null")
    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @NotBlank(message = "Last Name can not be blanc, empty string or null")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "email address can not be blanc, empty string or null")
    @Column(nullable = false)
    private String email;
    private String username;
    private String password;
    private String rawPassword;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    @JsonManagedReference
    List<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    List<Address> addresses;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    @JsonBackReference
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    List<Order> orders;


}
