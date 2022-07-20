package com.etlservice.schedular.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable=false, unique=true)
    @NotNull
    private String userName;

    @Column(name="first_name", nullable=false)
    @NotNull
    private String userFirstName;

    @Column(name="last_name", nullable=false)
    @NotNull
    private String userLastName;

    @Column(name="email", nullable=false)
    @NotNull
    private String userEmail;

    @Column(name="password", nullable=false)
    @NotNull
    private String userPassword;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
}
