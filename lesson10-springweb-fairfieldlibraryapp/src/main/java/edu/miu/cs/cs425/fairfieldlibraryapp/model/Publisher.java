package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Publishers")
//@ToString

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Publisher(Integer publisherId, String name, Address address) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_primary_address_id", nullable = true)
    private Address address;

    public Publisher() {
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("PublisherId: %d, Name:%d", "primary address: %s", this.publisherId, this.address, this.name);
    }

}
