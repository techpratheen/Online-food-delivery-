package com.tech.pro.repository;

import com.tech.pro.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query("SELECT r FROM Restaurant r WHERE r.name = :name")
    Restaurant findByname(String name);
}
