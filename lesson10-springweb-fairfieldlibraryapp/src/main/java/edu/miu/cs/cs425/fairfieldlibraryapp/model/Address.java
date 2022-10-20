package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressID;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    private Publisher publisher;
    @Override
    public String toString () {
        return String.format("addressID:%d, street:%s, city: %s, state:%s, zipCoder: %s",
                this.addressID, this.street, this.city, this.state, this.zipCode);
    }
}
