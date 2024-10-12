package com.user.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT", length = 800)
    private String about;
    @Transient
    private List<Rating> rating = new ArrayList<>();

}
