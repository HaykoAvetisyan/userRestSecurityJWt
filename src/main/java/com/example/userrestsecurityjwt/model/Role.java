package com.example.userrestsecurityjwt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "roles")
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    List<User> users;

}
