package com.tech.pro.repository;

import com.tech.pro.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.userName = :userName")
    Users findByUserName(String userName);
}
