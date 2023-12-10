package com.springsecuritypractice.SpringMVCSecurity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(nullable = false)
   private String name;

   @ManyToMany(mappedBy = "role")
   private List<User> user;

    public Long getId() {
        return id;
    }

    public Role(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
