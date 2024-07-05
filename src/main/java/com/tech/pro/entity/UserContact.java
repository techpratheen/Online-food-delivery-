package com.tech.pro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "user_contact")
public class UserContact {

    @Id
    @SequenceGenerator(name = "user_contact_seq", sequenceName = "user_contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "alternate_email")
    private String alternateEmail;

    @Column(name = "alternate_phone")
    private String alternatePhone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserContact )) return false;
        return id != null && id.equals(((UserContact) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
