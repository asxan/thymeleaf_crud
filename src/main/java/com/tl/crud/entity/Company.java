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
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "industry", nullable = false)
    private String industry;

    @Column(name = "founder", nullable = false)
    private String founder;

    @Column(name = "founding_year", nullable = false)
    private Integer foundingYear;

    @OneToOne(cascade = CascadeType.ALL)
    private Capitalization capitalization;

    @ManyToMany(mappedBy = "companies")
    @ToString.Exclude
    private Set<Investor> investors;

    public Company() {
        investors = new HashSet<>();
    }
}
