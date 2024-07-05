package com.tech.pro.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserAddress> userAddresses;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserContact> userContacts;

}
