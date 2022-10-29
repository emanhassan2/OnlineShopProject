package edu.miu.cs425.onlineshoppingapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String status;
    private LocalDate createdDate;
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonManagedReference
    private User user;

    @OneToOne
    @JoinColumn
    private OrderStatus orderStatus;
}
