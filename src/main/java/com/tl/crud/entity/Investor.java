package com.tl.crud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "investors")
public class Investor extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    private Finance financialStatus;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "inv_comp",
            joinColumns = @JoinColumn(name = "inv_id"),
            inverseJoinColumns = @JoinColumn(name = "comp_id")
    )
    @ToString.Exclude
    private Set<Company> companies;

    public Investor() {
        this.companies = new HashSet<>();
    }
}
