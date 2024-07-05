package com.tech.pro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "restaurant_contact")
public class RestaurantContact {

    @Id
    @SequenceGenerator(name = "restaurant_contact_seq", sequenceName = "restaurant_contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_contact_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "instagram")
    private String instagram;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  RestaurantContact )) return false;
        return id != null && id.equals(((RestaurantContact) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
