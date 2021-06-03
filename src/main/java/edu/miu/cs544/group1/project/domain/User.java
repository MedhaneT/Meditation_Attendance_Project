package edu.miu.cs544.group1.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
